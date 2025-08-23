import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];

        int[][] dirs = {{0, 1}, {1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], r = curr[1], c = curr[2];

            if (r == m - 1 && c == n - 1) return cost;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < m && nc < n) {
                    int newCost = cost + grid[nr][nc];
                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new int[]{newCost, nr, nc});
                    }
                }
            }
        }

        return -1; 
    }
}
