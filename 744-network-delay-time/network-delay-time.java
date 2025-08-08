class Solution {
    public int networkDelayTime(int[][] ar, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());         // node: node,dist
        }
        for (int i = 0; i < ar.length; i++) {
            adj.get(ar[i][0]-1).add(new int[]{ar[i][1]-1,ar[i][2]});    
            // adj.get(ar[i][1]).add(new int[]{ar[i][0],ar[i][2]});
        }
        
        PriorityQueue<int[]> pq=
        new PriorityQueue<>( (a, b) -> Integer.compare(a[1], b[1]));
            // pq storing node,distance
            
        int dist[]=new int[n];
        for(int i=0;i<n;i++)
        dist[i]=Integer.MAX_VALUE;
        
        dist[k-1]=0;
        pq.add(new int[]{k-1,0});
        while(!pq.isEmpty())
        {
            int temp[]=pq.poll();
            int node=temp[0];
            int dis=temp[1];
            for(int i=0;i<adj.get(node).size();i++){
                int[] arr=adj.get(node).get(i);
                int node1=arr[0];
                int cur_d=arr[1];           // distance between the node and node1
                if(dist[node1]>cur_d+dis){
                    pq.add(new int[]{node1,cur_d+dis});
                    dist[node1]=cur_d+dis;
                }
            }
        }
        int min=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            System.out.println(dist[i]);
            if(dist[i]==Integer.MAX_VALUE)  return -1;
            else min=Math.max(min,dist[i]);
        }
        return min;    
    }
} 