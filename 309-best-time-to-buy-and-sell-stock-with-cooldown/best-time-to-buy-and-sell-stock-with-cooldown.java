class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] dp1:dp)Arrays.fill(dp1,-1);
        return help(prices,0,dp,0); 
    }
    int help(int[] p,int index,int[][] dp,int buy){ 
        if(index>=p.length)   return 0;
        if(dp[index][buy]!=-1)   return dp[index][buy];
        int max=Integer.MIN_VALUE;
        if(buy==0){
            int pp=-p[index]+help(p,index+1,dp,1);
            int n=help(p,index+1,dp,buy);
            return dp[index][buy]=Math.max(pp,n);
        }

            // int pp=Integer.MIN_VALUE;
            // int c=p[index]-buy;
            int pp=p[index]+help(p,index+2,dp,0);
            int n=help(p,index+1,dp,buy);
            max=Math.max(pp,n);
            // return max;
        return dp[index][buy]=max;
    }
}