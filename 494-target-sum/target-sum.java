class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            // Arrays.fill(dp[i],-1);
        }
        int[][] dp = new int[nums.length][sum+1];    
        for(int[] i:dp) Arrays.fill(i,-1);
        return help(dp,nums.length-1,nums,target,sum,0); 
    }

    int help(int[][] dp,int index,int[] nums,int target,int sum,int s1){
        
        // if(Math.abs(2*s1-sum)==target)  return 1;

        // if(index==-1){
        //     if(Math.abs(2*s1-sum)==target)  return 1;
        //     return 0;
        // }

        if (index == -1) {
            int s2 = sum - s1;
            if (target == s1 - s2)return 1;
            return 0;
        }

        if (dp[index][s1] != -1) return dp[index][s1];

        int notPick = help(dp,index - 1,nums,target,sum,s1);
        int pick = help(dp,index-1,nums,target,sum,s1+nums[index]);

        return dp[index][s1] = notPick + pick;

    }
}