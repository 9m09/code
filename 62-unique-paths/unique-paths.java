class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1)    return 1;
        int[][] grid=new int[m][n];
        for(int j=0;j<n;j++)    grid[1][j]=j+1;
        for(int i=2;i<m;i++){
            grid[i][0]=1;
            for(int j=1;j<n;j++){
                grid[i][j]=grid[i][j-1]+grid[i-1][j];
            }
        }

        return  grid[m-1][n-1];
    }
}