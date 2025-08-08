class Solution {
    public int findCheapestPrice(int n, int[][] ar, int src, int dst, int k1) {
        k1=k1+2;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());         // node: node,dist
        }
        for (int i = 0; i < ar.length; i++) {
            adj.get(ar[i][0]).add(new int[]{ar[i][1],ar[i][2]});    
            // adj.get(ar[i][1]).add(new int[]{ar[i][0],ar[i][2]});
        }
        
        Queue<int[]> pq = new LinkedList<>();
            // pq storing node,distance and k
            
        int dist[]=new int[n];
        for(int i=0;i<n;i++)
        dist[i]=Integer.MAX_VALUE;
        
        dist[src]=0;
        pq.add(new int[]{src,0,1});
        while(!pq.isEmpty())
        {
            int temp[]=pq.poll();
            int node=temp[0];
            int dis=temp[1];
            int k = temp[2];
            for(int i=0;i<adj.get(node).size();i++){
                int[] arr=adj.get(node).get(i);
                int node1=arr[0];
                int cur_d=arr[1];           // distance between the node and node1
                if(k+1<=k1&&dist[node1]>cur_d+dis){
                    pq.add(new int[]{node1,cur_d+dis,k+1});
                    dist[node1]=cur_d+dis;
                }
            }
        }    
        if(dist[dst]==Integer.MAX_VALUE)    return -1;
        return dist[dst];
    }
}