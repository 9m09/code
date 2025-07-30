class Solution {
    public void sortColors(int[] nums) {
        int o=0;
        int t=nums.length-1;
        int i=0;
        while(i<=t){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[o];
                nums[o]=temp;
                i++;
                o++;
            }
            else if(nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[t];
                nums[t]=temp;
                // i++;
                t--;
            }
            else
            i++;
        }    
    }
}
// class Solution{

// public void sortColors(int[] nums) {
//     int o = 0, mid = 0, t = nums.length - 1;
//     while (mid <= t) {
//         if (nums[mid] == 0) {
//             int tmp = nums[o];
//             nums[o++] = nums[mid];
//             nums[mid++] = tmp;
//         } else if (nums[mid] == 1) {
//             mid++;
//         } else {
//             int tmp = nums[mid];
//             nums[mid] = nums[t];
//             nums[t--] = tmp;
//         }
//     }
// }
// }