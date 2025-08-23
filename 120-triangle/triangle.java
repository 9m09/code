class Solution {
    public int minimumTotal(List<List<Integer>> tr) {
        int[][] dp = new int[tr.size()][];
        for(int i=0;i<tr.size();i++){
            dp[i]=new int[tr.get(i).size()];
        }

        dp[0][0]=tr.get(0).get(0);
        for(int i=1;i<tr.size();i++){
            for(int j=0;j<tr.get(i).size();j++){
                int up=Integer.MAX_VALUE;
                int di=Integer.MAX_VALUE;
                if(j<dp[i-1].length)    up=dp[i-1][j]; 
                if(j!=0)    di=dp[i-1][j-1];
                int min=Math.min(up,di);
                dp[i][j]=(min==Integer.MAX_VALUE?0:min)+tr.get(i).get(j);
            }
        } 

        int min=Integer.MAX_VALUE;
        for(int j=0;j<dp[tr.size()-1].length;j++){
            min=Math.min(min,dp[tr.size()-1][j]);
        }
        return min;
    }
}