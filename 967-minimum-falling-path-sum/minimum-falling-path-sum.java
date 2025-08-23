class Solution {
    public int minFallingPathSum(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        for(int j=0;j<mat[0].length;j++)    dp[0][j]=mat[0][j];
        for(int i=1;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                int up=dp[i-1][j];
                if(j-1>=0)    ld=dp[i-1][j-1];
                if(j+1<mat[0].length)    rd=dp[i-1][j+1];
                dp[i][j]=Math.min(Math.min(up,ld),rd)+mat[i][j];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<mat[0].length;j++)    min=Math.min(min,dp[mat.length-1][j]);
        return min;
    }
}