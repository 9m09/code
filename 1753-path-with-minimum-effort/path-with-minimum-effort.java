class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dif = new int[heights.length][heights[0].length];
        for(int[] i:dif){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dif[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[2],b[2]));
        // store i,j,diff
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int i=temp[0];
            int j=temp[1];
            int diff=temp[2];

            if(i+1<heights.length){
                int d=Math.abs(heights[i][j]-heights[i+1][j]);
                int max=Math.max(d,diff);
                if(dif[i+1][j]>max){
                    pq.add(new int[]{i+1,j,max});
                    dif[i+1][j]=max;
                }
            }
            if(j+1<heights[0].length){
                int d=Math.abs(heights[i][j]-heights[i][j+1]);
                int max=Math.max(d,diff);
                if(dif[i][j+1]>max){
                    pq.add(new int[]{i,j+1,max});
                    dif[i][j+1]=max;
                }
            }
            if(i-1>-1){
                int d=Math.abs(heights[i][j]-heights[i-1][j]);
                int max=Math.max(d,diff);
                if(dif[i-1][j]>max){
                    pq.add(new int[]{i-1,j,max});
                    dif[i-1][j]=max;
                }
            }
            if(j-1>-1){
                int d=Math.abs(heights[i][j]-heights[i][j-1]);
                int max=Math.max(d,diff);
                if(dif[i][j-1]>max){
                    pq.add(new int[]{i,j-1,max});
                    dif[i][j-1]=max;
                }
            }
        }
        return dif[heights.length-1][heights[0].length-1];
    }
}