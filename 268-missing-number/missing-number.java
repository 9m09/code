class Solution {
    public int missingNumber(int[] nums) {
        int mis=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i])  return i;  
        }
        return mis;    
    }
} 