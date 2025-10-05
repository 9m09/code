class Solution {
    int kk;
    public int maxProfit(int k, int[] prices) {
        kk=k;
        int[][][] dp = new int[prices.length][2][k];
        for(int [][]dp1:dp){
        for(int[] dpp:dp1)Arrays.fill(dpp,-1);
        }
        return help(prices,0,dp,0,0);   
    }
    int help(int[] p,int index,int[][][] dp,int buy,int count){ 
        if(count==kk)    return 0;
        if(index==p.length)   return 0;
        if(dp[index][buy][count]!=-1)   return dp[index][buy][count];
        int max=Integer.MIN_VALUE;
        if(buy==0){
            int pp=-p[index]+help(p,index+1,dp,1,count);
            int n=help(p,index+1,dp,buy,count);
            return dp[index][buy][count]=Math.max(pp,n);
        }

            // int pp=Integer.MIN_VALUE;
            // int c=p[index]-buy;
            int pp=p[index]+help(p,index,dp,0,count+1);
            int n=help(p,index+1,dp,buy,count);
            max=Math.max(pp,n);
            // return max;
        return dp[index][buy][count]=max;
    }
}