class Solution {
    public int uniquePathsWithObstacles(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        if(maze[0][0]==1||maze[n-1][m-1]==1)    return 0;

        int dp[][] = new int[n][m];
        
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        return mazeObstaclesUtil(n - 1, m - 1, maze, dp);

    }

     static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {

        if (i == 0 && j == 0)   return 1;
        if (i < 0 || j < 0) return 0;
        if (maze[i][j] == 1)    return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int up = mazeObstaclesUtil(i - 1, j, maze, dp);
        int left = mazeObstaclesUtil(i, j - 1, maze, dp);

        return dp[i][j] = up + left;
    }
}