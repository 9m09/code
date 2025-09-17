class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        int c= help(dp,coins.length-1,amount,coins);             
        return c==Integer.MAX_VALUE?-1:c;
    }

    int help(int[][] dp,int ind,int amount,int[] coins){

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        if(amount==0)   return  0;

        if(ind==0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return Integer.MAX_VALUE;
        }

        int not = help(dp,ind-1,amount,coins);

        int pick = Integer.MAX_VALUE; 
        for(int i=1;i<=amount/coins[ind];i++){
            if(amount>=coins[ind]*i){
                int cat=help(dp,ind-1,amount-coins[ind]*i,coins);
                if(cat!=Integer.MAX_VALUE)
                pick=Math.min((cat+i),pick);

            }
        }

        return dp[ind][amount] = Math.min(pick,not);
    }
} 

// import java.util.*;

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount + 1); // use amount+1 as "infinity"
//         dp[0] = 0;

//         for (int coin : coins) {
//             for (int x = coin; x <= amount; x++) {
//                 dp[x] = Math.min(dp[x], dp[x - coin] + 1);
//             }
//         }

//         return dp[amount] > amount ? -1 : dp[amount];
//     }
// }
