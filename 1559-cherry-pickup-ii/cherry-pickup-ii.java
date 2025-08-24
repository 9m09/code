class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int [grid.length][grid[0].length][grid[0].length];
        for(int j1=0;j1<grid[0].length;j1++){
            for(int j2=0;j2<grid[0].length;j2++){
                if(j1==j2)  dp[grid.length-1][j1][j2]=grid[grid.length-1][j2];
                else    dp[grid.length-1][j1][j2]=grid[grid.length-1][j1]+grid[grid.length-1][j2];
            }
        }
        for(int i=grid.length-2;i>=0;i--){
            for (int j1 = 0; j1 < grid[0].length; j1++) {
                for (int j2 = 0; j2 < grid[0].length; j2++) {
                    int max=Integer.MIN_VALUE;
                    for(int r1=-1;r1<=1;r1++){
                        for(int r2=-1;r2<=1;r2++){
                            int value;
                            if(j1==j2)  value=grid[i][j1];
                            else    value=grid[i][j1]+grid[i][j2];
                            if ((j1 + r1 < 0 || j1 + r1 >= grid[0].length) || (j2 + r2 < 0 || j2 + r2 >= grid[0].length))
                                max=Math.max(max,value);
                            else    max=Math.max(max,value+dp[i+1][j1+r1][j2+r2]);

                        }
                    }
                    dp[i][j1][j2]=max;
                }
            }
        }

        return dp[0][0][grid[0].length-1];
    }
}