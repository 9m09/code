class Solution {
   
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        if(stones.length==2)    return true;    
        Set<Integer> stoneSet = new HashSet<>();
        for (int stone : stones) {
            stoneSet.add(stone);
        }
        int lastStone = stones[stones.length - 1];

        Queue<int[]> queue = new LinkedList<>( );
        queue.add(new int[]{1, 1});
        Set<String> vi = new HashSet<>();
        vi.add("1,1");
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0];
            int jump = curr[1];

            for (int step = jump - 1; step <= jump + 1; step++) {
                if (step ==0) continue; 
                int nextPos = pos + step;

                if (nextPos == lastStone) return true;

                if (stoneSet.contains(nextPos)) {
                    String state = nextPos + "," + step;
                    if(!vi.contains(state)){
                        vi.add(state);
                        queue.add(new int[]{nextPos, step});
                    }
                }
            }
        }
        return false;
    }
}