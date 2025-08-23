class Solution {
    public int minimumTotal(List<List<Integer>> tr) {
        int[][] dp = new int[tr.size()][];

        for(int i=0;i<tr.size();i++){
            dp[i]=new int[tr.get(i).size()];
            Arrays.fill(dp[i],-1);
        }
        int min=Integer.MAX_VALUE;
        for(int j=tr.get(tr.size()-1).size()-1;j>=0;j--)   
            min=Math.min(help(dp,tr,tr.size()-1,j),min);
           
        return min;   
    }
    int help(int[][] dp , List<List<Integer>> tr,int i, int j){
        if(i==0&&j==0)  return dp[0][0]=tr.get(0).get(0);
        // if(i<0||j<0)    return Integer.MAX_VALUE;
        if (i < 0 || j < 0 || j >= tr.get(i).size()) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1)    return dp[i][j];

        int up=help(dp,tr,i-1,j-1);
        int left=help(dp,tr,i-1,j);

        return dp[i][j]=Math.min(up,left)+tr.get(i).get(j);

    }
}
