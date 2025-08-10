class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int trg) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        sub(nums,0,trg,0,res,new ArrayList<>());
        return res;
    }
    void sub(int[] nums,int index,int trg,int sum,List<List<Integer>> res,List<Integer> tl){
        if(sum==trg){
            res.add(new ArrayList<>(tl));
            return;
        }
        if(index==nums.length)  return;
        if(sum+nums[index]<=trg){
            tl.add(nums[index]);
            sub(nums,index+1,trg,sum+nums[index],res,tl);
            tl.remove(tl.size()-1);
        }
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        sub(nums,index+1,trg,sum,res,tl);

    }
}