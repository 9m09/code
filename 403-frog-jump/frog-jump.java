// class Solution {
   
//     public boolean canCross(int[] stones) {
//         if (stones[1] != 1) return false;
//         if(stones.length==2)    return true;    
//         Set<Integer> stoneSet = new HashSet<>();
//         for (int stone : stones) {
//             stoneSet.add(stone);
//         }
//         int lastStone = stones[stones.length - 1];

//         Queue<int[]> queue = new LinkedList<>( );
//         queue.add(new int[]{1, 1});
//         Set<String> vi = new HashSet<>();
//         vi.add("1,1");
//         while (!queue.isEmpty()) {
//             int[] curr = queue.poll();
//             int pos = curr[0];
//             int jump = curr[1];

//             for (int step = jump - 1; step <= jump + 1; step++) {
//                 if (step ==0) continue; 
//                 int nextPos = pos + step;

//                 if (nextPos == lastStone) return true;

//                 if (stoneSet.contains(nextPos)) {
//                     String state = nextPos + "," + step;
//                     if(!vi.contains(state)){
//                         vi.add(state);
//                         queue.add(new int[]{nextPos, step});
//                     }
//                 }
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) return false;

        // dp[i] = set of jumps that can land on stone i
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        dp.get(0).add(0);

        for (int stone : stones) {
            for (int k : dp.get(stone)) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && dp.containsKey(stone + step)) {
                        dp.get(stone + step).add(step);
                        if (stone + step == stones[n - 1]) return true;
                    }
                }
            }
        }

        return false;
    }
}
