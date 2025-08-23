//memoization
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int[][] dp = new int[grid.length][grid[0].length];
//         for(int[] dpp:dp)
//         Arrays.fill(dpp,-1);
//         return help(dp,grid,grid.length-1,grid[0].length-1);        
//     }
//     int help(int[][] dp,int[][] grid,int i,int j){
//         if(i==0&&j==0)  return dp[0][0]=grid[0][0];
//         if(i<0||j<0)    return Integer.MAX_VALUE;

//         if(dp[i][j]!=-1)    return dp[i][j];

//         int up=help(dp,grid,i-1,j);
//         int left=help(dp,grid,i,j-1);

//         return dp[i][j]=grid[i][j]+Math.min(up,left);

//     }
// }

// tabulation
class Solution{
        public int minPathSum(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;

            int[][] dp =new int[m][n];

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0&&j==0)  dp[0][0]=grid[0][0];
                    else{
                        int up=Integer.MAX_VALUE;
                        int left=Integer.MAX_VALUE;
                        if(i!=0) up=dp[i-1][j];
                        if(j!=0) left=dp[i][j-1];
                        int min=Math.min(up,left)+grid[i][j];
                        dp[i][j]=min;
                    }
                }
            }


            return dp[m-1][n-1];
        }

}