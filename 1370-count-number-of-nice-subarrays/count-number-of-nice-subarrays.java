class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // int odd=1;
        int min=-1;
        Queue<Integer> q = new LinkedList<>();
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i]%2!=0)   {
                min=i;
                // q.add(i);
                break;
            } 
        }
        
        if(min==-1) return 0;

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
                // System.out.print(l);
            }
            if(odd==k)  count=count+q.peek()-l+1;
            
        }

        // for(;i<nums.length;i++){
        //     if(nums[i]%2!=0)    odd++;
        //     if(odd==k){
        //         while(odd==k){
        //             count=count+l;
        //         }
        //     }  
        // }
        return count;
    }
}