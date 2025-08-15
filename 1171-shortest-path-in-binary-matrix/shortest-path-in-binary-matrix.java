class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] dis = new int[n][n];
        for (int[] row : dis) Arrays.fill(row, Integer.MAX_VALUE);

        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true; // starting point is visited
        dis[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            int d = dis[i][j];

            // Down-Right
            if (i + 1 < n && j + 1 < n && grid[i + 1][j + 1] == 0 && !vis[i + 1][j + 1]) {
                dis[i + 1][j + 1] = d + 1;
                vis[i + 1][j + 1] = true;
                queue.add(new int[]{i + 1, j + 1});
            }

            // Down
            if (i + 1 < n && grid[i + 1][j] == 0 && !vis[i + 1][j]) {
                dis[i + 1][j] = d + 1;
                vis[i + 1][j] = true;
                queue.add(new int[]{i + 1, j});
            }

            // Right
            if (j + 1 < n && grid[i][j + 1] == 0 && !vis[i][j + 1]) {
                dis[i][j + 1] = d + 1;
                vis[i][j + 1] = true;
                queue.add(new int[]{i, j + 1});
            }

            // Up
            if (i - 1 >= 0 && grid[i - 1][j] == 0 && !vis[i - 1][j]) {
                dis[i - 1][j] = d + 1;
                vis[i - 1][j] = true;
                queue.add(new int[]{i - 1, j});
            }

            // Left
            if (j - 1 >= 0 && grid[i][j - 1] == 0 && !vis[i][j - 1]) {
                dis[i][j - 1] = d + 1;
                vis[i][j - 1] = true;
                queue.add(new int[]{i, j - 1});
            }

            // Up-Left
            if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 0 && !vis[i - 1][j - 1]) {
                dis[i - 1][j - 1] = d + 1;
                vis[i - 1][j - 1] = true;
                queue.add(new int[]{i - 1, j - 1});
            }

            // Up-Right
            if (i - 1 >= 0 && j + 1 < n && grid[i - 1][j + 1] == 0 && !vis[i - 1][j + 1]) {
                dis[i - 1][j + 1] = d + 1;
                vis[i - 1][j + 1] = true;
                queue.add(new int[]{i - 1, j + 1});
            }

            // Down-Left
            if (i + 1 < n && j - 1 >= 0 && grid[i + 1][j - 1] == 0 && !vis[i + 1][j - 1]) {
                dis[i + 1][j - 1] = d + 1;
                vis[i + 1][j - 1] = true;
                queue.add(new int[]{i + 1, j - 1});
            }
        }

        return dis[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : dis[n - 1][n - 1];
    }
}
