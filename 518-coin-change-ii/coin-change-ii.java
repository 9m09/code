class Solution {
    
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        int c= help(dp,coins.length-1,amount,coins);             
        return c;
    }

    int help(int[][] dp,int ind,int amount,int[] coins){

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        if(amount==0)   return  1;

        if(ind==0){
            if(amount%coins[0]==0) return 1;
            else return 0;
        }

        int not = help(dp,ind-1,amount,coins);

        int pick = 0; 
        for(int i=1;i<=amount/coins[ind];i++){
            if(amount>=coins[ind]*i){
                int cat=help(dp,ind-1,amount-coins[ind]*i,coins);
                if(cat!=0)
                    pick=pick+cat;
                // pick=Math.min((cat+i),pick);
            }
        }

        return dp[ind][amount] = pick+not;
    }
}