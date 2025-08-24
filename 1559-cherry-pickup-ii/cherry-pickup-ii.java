class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] dpp:dp){
            for(int[] dppp:dpp) Arrays.fill(dppp,-1);
        }
        return help(dp,grid,0,0,grid[0].length-1);    
    }
    int help(int[][][] dp,int[][] grid,int i,int j1,int j2){
        if(j1<0||j1>=grid[0].length||j2<0||j2>=grid[0].length)  return 0;
        if(i==grid.length-1){
            if(j1==j2)  return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1)   return dp[i][j1][j2];
        int max=Integer.MIN_VALUE;
        int value;
        for(int r1=-1;r1<=1;r1++){
            for(int r2=-1;r2<=1;r2++){
                if(j1==j2)  value=grid[i][j1];
                else    value=grid[i][j1]+grid[i][j2];
                max=Math.max(max,value+help(dp,grid,i+1,j1+r1,j2+r2));
            }
        }
        return dp[i][j1][j2]=max;
    }
}