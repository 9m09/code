class Solution {
    // public int uniquePaths(int m, int n) {
    //     if(m==1)    return 1;
    //     int[][] grid=new int[m][n];
    //     for(int j=0;j<n;j++)    grid[1][j]=j+1;
    //     for(int i=2;i<m;i++){
    //         grid[i][0]=1;
    //         for(int j=1;j<n;j++){
    //             grid[i][j]=grid[i][j-1]+grid[i-1][j];
    //         }
    //     }

    //     return  grid[m-1][n-1];
    // }

    //memoization
    // public int uniquePaths(int m, int n){
    //     if(m==1)    return 1;
    //     int[][] dp = new int[m][n];
    //     for(int[] dpp:dp)
    //     Arrays.fill(dpp,-1);
    //     return help(dp,m-1,n-1);
    // }
    // int help(int[][] dp,int i,int j){
    //     if(i==0&&j==0)  return 1;
    //     if(i<0||j<0)    return 0;
    //     if(dp[i][j]!=-1)    return dp[i][j];

    //     int up=help(dp,i-1,j);
    //     int left=help(dp,i,j-1);

    //     return dp[i][j]=left+up;
    // }

    //tabulation
    public int uniquePaths(int m, int n){
        // if(m==1)    return 1;
    
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&j==0)   dp[0][0]=1;
                else{
                    int up=0;
                    int left=0;
                    if(i!=0)    up=dp[i-1][j];
                    if(j!=0)    left=dp[i][j-1];
                    dp[i][j]=left+up;
                }
            }
        }

        return dp[m-1][n-1];
    }
}