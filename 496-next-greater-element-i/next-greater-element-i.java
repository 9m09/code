class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        int[] nge= new int[nums2.length];
        nge[nums2.length-1]=-1;
        stack.push(nums2[nums2.length-1]);
        for(int i=nums2.length-2;i>=0;i--){
            if(nums2[i]<stack.peek()){
                nge[i]=stack.peek();
                stack.push(nums2[i]);
            }
            else{
                // while(!(stack.peek()>nums2[i])&&!(stack.empty())){
                while (!stack.empty() && (stack.peek() < nums2[i])) { // was: while (!(stack.peek()>nums2[i])&&!(stack.empty()))
                    stack.pop();
                }
                if(stack.empty()){
                    nge[i]=-1;
                }
                else{
                    nge[i]=stack.peek();
                }
                stack.push(nums2[i]);
            }

        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    arr[i]=nge[j];
                }
            }
        }
        return arr;
    }
}