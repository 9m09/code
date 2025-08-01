class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // int[] arr=new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        // int[] nge= new int[nums2.length];
        Map<Integer, Integer> map = new HashMap<>(); // num -> next greater
        map.put(nums2[nums2.length-1],-1);
        // nge[nums2.length-1]=-1;
        stack.push(nums2[nums2.length-1]);
        for(int i=nums2.length-2;i>=0;i--){
            if(nums2[i]<stack.peek()){
                // nge[i]=stack.peek();
                map.put(nums2[i],stack.peek());
                stack.push(nums2[i]);
            }
            else{
                // while(!(stack.peek()>nums2[i])&&!(stack.empty())){
                while (!stack.empty() && (stack.peek() < nums2[i])) { // was: while (!(stack.peek()>nums2[i])&&!(stack.empty()))
                    stack.pop();
                }
                if(stack.empty()){
                    // nge[i]=-1;
                    map.put(nums2[i],-1);
                }
                else{
                    // nge[i]=stack.peek();
                    map.put(nums2[i],stack.peek());

                }
                stack.push(nums2[i]);
            }

        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}