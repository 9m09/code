class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp,-1);
        return help(prices,0,dp,-1);    
    }
    int help(int[] p,int index,int[] dp,int buy){

        if(index==p.length)   return 0;
        if(dp[index]!=-1)   return dp[index];
        int max=Integer.MIN_VALUE;
        if(buy==-1){
            int pp=help(p,index+1,dp,p[index]);
            int n=help(p,index+1,dp,buy);
            return dp[index]=Math.max(pp,n);
        }
        // else{
            int pp=Integer.MIN_VALUE;
            int c=p[index]-buy;
            // if(c>=0)
            pp=help(p,index,dp,-1)+c;
            int n=help(p,index+1,dp,buy);
            max=Math.max(pp,n);
        // }

        return dp[index]=max;

    }
}