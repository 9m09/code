class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[nums.length];
        nge[nums.length-1]=-1;
        stack.push(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<stack.peek()){
                nge[i]=stack.peek();
                stack.push(nums[i]);
            }
            else{
                while(!stack.isEmpty()&&stack.peek()<nums[i]) stack.pop();
                if(stack.isEmpty()) nge[i]=-1;
                else nge[i]=stack.peek();
                stack.push(nums[i]);
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<stack.peek()){
                nge[i]=stack.peek();
                stack.push(nums[i]);
            }
            else{
                while(!stack.isEmpty()&&stack.peek()<=nums[i]) stack.pop();
                if(stack.isEmpty()) nge[i]=-1;
                else nge[i]=stack.peek();
                stack.push(nums[i]);
            }
        }
        return nge;
    }
}