class Solution {
    public int minDistance(String w1, String w2) {
        int[][] dp = new int[w1.length()][w2.length()];
        for(int[] i:dp) Arrays.fill(i,-1);
        return help(w1,w1.length()-1,w2,w2.length()-1,dp);     
    }
    int help(String w1,int i1,String w2,int i2,int[][] dp){
        
        if(i1==-1)  return i2+1;

        if(i2==-1)  return i1+1;

        if(dp[i1][i2]!=-1)  return dp[i1][i2];

        if(w1.charAt(i1)==w2.charAt(i2))    return dp[i1][i2]=help(w1,i1-1,w2,i2-1,dp);

        int in=help(w1,i1,w2,i2-1,dp);
        int de=help(w1,i1-1,w2,i2,dp);
        int re=help(w1,i1-1,w2,i2-1,dp);

        return dp[i1][i2]=1+Math.min(Math.min(in,de),re);
    }
}