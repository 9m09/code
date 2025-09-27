class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] i:dp) Arrays.fill(i,-1);
        return help(s,s.length()-1,t,t.length()-1,dp);
    }
    int help(String s,int is, String t,int it,int[][] dp){
        
        if(it==-1)  return 1;
        if(is==-1)  return 0;
        if(dp[is][it]!=-1)  return dp[is][it];
        int pick=0;
        if(s.charAt(is)==t.charAt(it)){
            pick=help(s,is-1,t,it-1,dp);
        }
        
        return dp[is][it]=help(s,is-1,t,it,dp)+pick;
    }
}