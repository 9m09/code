class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // int odd=1;
        Queue<Integer> q = new LinkedList<>();
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i]%2!=0)   {
                break;
            } 
        }
        
        if(i==nums.length) return 0;

        int l=0,count=0;
        int odd=0;
        for(;i<nums.length;i++){
            if(nums[i]%2!=0)  {
                q.add(i);
                odd++;
            }  
            while(odd>k){
                if(nums[l]%2!=0)    {
                    q.poll();
                    odd--;
                }
                l++;
            }
            if(odd==k)  count=count+q.peek()-l+1;
            
        }

        
        return count;
    }
}