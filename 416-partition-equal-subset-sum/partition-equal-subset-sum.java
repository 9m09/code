class Solution {
    public boolean canPartition(int[] nums) {
        int target=0;
        for(int i:nums) target=target+i;
        if(target%2!=0) return false;
        Boolean[][] dp = new Boolean[nums.length][target+1];
        return help(nums,target/2,dp,nums.length-1);    
    }
    boolean help(int[] nums,int target,Boolean[][] dp,int ind){
        if(dp[ind][target]!=null)   return dp[ind][target];
        if(target==0)   return dp[ind][target]=true;;
        if(ind==0){
            return nums[ind]==target;
        }
        boolean pick=false;
        if(target>=nums[ind])
        pick=help(nums,target-nums[ind],dp,ind-1);
        boolean not=help(nums,target,dp,ind-1);
        return dp[ind][target]=pick||not;
    }
}