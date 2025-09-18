// shifting of indexes towards right
class Solution {
    int l=0;

    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp = new int[t1.length()+1][t2.length()+1];
        for(int[] i: dp)    Arrays.fill(i,-1);
        return help(t1, t1.length(), t2, t2.length(),dp);    
    }

    int help(String t1, int i1, String t2, int i2,int[][] dp){
        
        if(i1==0||i2==0){
            return 0;
        }

        if(dp[i1][i2]!=-1)  return dp[i1][i2];

        if(t1.charAt(i1-1)==t2.charAt(i2-1))    return dp[i1][i2]= 1 + help(t1, i1-1, t2, i2-1,dp);
        // changed form i1 to i1-1 and i2 to i2-1 because we have shifted for the ease 
        // but in strings s1 and s2 we have fixed size and it can give out of bound exception for first time

        return dp[i1][i2]=Math.max(help(t1, i1-1, t2, i2,dp), help(t1, i1, t2, i2-1,dp));
    }
}