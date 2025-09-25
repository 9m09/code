class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2="";
        for(int i=(s.length()-1);i>=0;i--){
            s2=s2+s.charAt(i);
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int[] i: dp)    Arrays.fill(i,-1);
        
        return help(s,s.length()-1,s2,s.length()-1,dp);
    }
     int help(String t1, int i1, String t2, int i2,int[][] dp){
        
        if(i1==-1||i2==-1){
            return 0;
        }

        if(dp[i1][i2]!=-1)  return dp[i1][i2];

        if(t1.charAt(i1)==t2.charAt(i2))    return dp[i1][i2]= 1 + help(t1, i1-1, t2, i2-1,dp);

        return dp[i1][i2]=Math.max(help(t1, i1-1, t2, i2,dp), help(t1, i1, t2, i2-1,dp));
    }
}
 