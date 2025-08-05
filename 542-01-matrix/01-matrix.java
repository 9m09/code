import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] mat) {   
        int[][] result = new int[mat.length][mat[0].length];
            
        Queue<Map.Entry<Integer,Integer>> queue = new LinkedList<>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    queue.add(new AbstractMap.SimpleEntry<>(i,j));
                    result[i][j]=0;
                    vis[i][j]=true;
                }
            }
        }

        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> map = queue.poll();
            int ii=map.getKey();
            int jj=map.getValue();
            int d=result[ii][jj];
            if(ii-1>-1&&!vis[ii-1][jj]){
                vis[ii-1][jj]=true;
                result[ii-1][jj]=d+1;
                queue.add(new AbstractMap.SimpleEntry<>(ii-1,jj));
            }
            if(ii+1<mat.length&&!vis[ii+1][jj]){
                vis[ii+1][jj]=true;
                result[ii+1][jj]=d+1;
                queue.add(new AbstractMap.SimpleEntry<>(ii+1,jj));
            }
            if(jj-1>-1&&!vis[ii][jj-1]){
                vis[ii][jj-1]=true;
                result[ii][jj-1]=d+1;
                queue.add(new AbstractMap.SimpleEntry<>(ii,jj-1));
            }
            if(jj+1<mat[0].length&&!vis[ii][jj+1]){
                vis[ii][jj+1]=true;
                result[ii][jj+1]=d+1;
                queue.add(new AbstractMap.SimpleEntry<>(ii,jj+1));
            }
            

        }
        return result;
    }
}
