class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(nums);
        sub(nums,0,n,0,res,new ArrayList<>(),k);
        return res;
    }
    void sub(int[] nums,int index,int trg,int sum,List<List<Integer>> res,List<Integer> tl,int size){
        if(sum==trg&&size==tl.size()){
            res.add(new ArrayList<>(tl));
            return;
        }
        if(index==nums.length)  return;
        if(sum+nums[index]<=trg&&tl.size()<=size){
            tl.add(nums[index]);
            sub(nums,index+1,trg,sum+nums[index],res,tl,size);
            tl.remove(tl.size()-1);
        }
        sub(nums,index+1,trg,sum,res,tl,size);

    }
}