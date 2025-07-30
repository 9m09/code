class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int cm=0;
        if(nums[0]==1)  cm++;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0){
                max=Math.max(max,cm);
                cm=0;
            }
            else    cm++;
        }  
        max=Math.max(max,cm); 
        return max; 
    }
}