class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)    return nums[0];
        int[] dp= new int[n];
        dp[0]=nums[0];

        dp[1]=Math.max(nums[1],nums[0]);        // dont take last element
        for(int i=2;i<n-1;i++){
            int take=dp[i-2]+nums[i];
            int not=dp[i-1];
            dp[i]=Math.max(not,take);
        }
        int[] dp2 = new int[n];
        dp2[1]=nums[1];
        for(int i=2;i<n;i++){                   // dont take first element
            int take=nums[i];
            if(i!=2)
            take=take+dp2[i-2];
            int not=dp2[i-1];
            dp2[i]=Math.max(take,not);
        }                             

        return Math.max(dp[n-2],dp2[n-1]);
    }
}