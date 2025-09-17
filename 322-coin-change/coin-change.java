class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        
        int ans = helper(n - 1, amount, coins, dp);
        return (ans >= (int) 1e9) ? -1 : ans;
    }

    private int helper(int index, int target, int[] coins, int[][] dp) {

        if (index == 0) {
            if (target % coins[0] == 0) return target / coins[0];
            return (int) 1e9; 
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = helper(index - 1, target, coins, dp);

        int take = (int) 1e9;
        if (coins[index] <= target) {
            take = 1 + helper(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = Math.min(notTake, take);
    }
}
