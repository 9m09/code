// class Solution {
//     int max=Integer.MIN_VALUE;
//     public int rob(int[] nums) {
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         help(nums,Integer.MIN_VALUE,0,0);
//         return max;
//     }
//     void help(int[] arr,int cmax,int i,int sum){
// 	    if(i>=arr.length){
//             if(i<arr.length)
//             sum=sum+arr[i];
// 	        max=Math.max(max,sum);			
// 			return;												
// 		}									

// 	    help(arr,cmax,i+2,sum+arr[i]);
//         help(arr,cmax,i+1,sum);
//     }
// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         int re= solve(nums, 0, dp);
//         for(int i=0;i<n;i++)
//         System.out.println(dp[i]);
//         return re;
//     }

//     int solve(int[] arr, int i, int[] dp) {
//         if (i >= arr.length) return 0;
//         if (dp[i] != -1) return dp[i]; 
        
//         int non = arr[i] + solve(arr, i + 2, dp);
//         int adj = solve(arr, i + 1, dp);

//         return dp[i] = Math.max(non, adj);
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int re= helper(nums, n-1, dp);
        for(int i=0;i<n;i++)
        System.out.println(dp[i]);
        return re;
    }

    int helper(int[] nums, int i, int[] dp) {
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];

        int rob = nums[i] + helper(nums, i - 2, dp);
        int skip = helper(nums, i - 1, dp);

        return dp[i] = Math.max(rob, skip);
    }
}
