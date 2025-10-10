class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); //prefixsum, their count 
        map.put(0, 1);  
        int count = 0;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}