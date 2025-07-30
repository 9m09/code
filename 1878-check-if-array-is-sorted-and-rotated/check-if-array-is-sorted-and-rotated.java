class Solution {
    public boolean check(int[] nums) {
        if(nums.length==1)  return true;
        int first=nums[0];
        int flag=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                flag++;
            }
        }
        if(flag==0) return true;
        else if(flag==1&&nums[nums.length-1]<=nums[0])    return true;

        return false;
    }
}