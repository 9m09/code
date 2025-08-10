class Solution {
    public int countPaths(int n, int[][] ar) {
        int mod = 1000000007; 
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());         // node: node,dist
        }
        for (int i = 0; i < ar.length; i++) {
            adj.get(ar[i][0]).add(new int[]{ar[i][1],ar[i][2]});    
            adj.get(ar[i][1]).add(new int[]{ar[i][0],ar[i][2]});
        }
        
       
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{0,0});

        int[] way = new int[n];
        Arrays.fill(way,0);    
        long dist[]=new long[n];
        for(int i=0;i<n;i++)
        dist[i]=Long.MAX_VALUE;
        dist[0]=0;
        way[0]=1;
        while(!pq.isEmpty())
        {
            long temp[]=pq.poll();
            int node=(int)temp[0];
            long dis=temp[1];

            for(int i=0;i<adj.get(node).size();i++){
                int[] arr=adj.get(node).get(i);
                int node1=arr[0];
                long cur_d=arr[1];           // distance between the node and node1
                if(dist[node1]==cur_d+dis){
                    way[node1]=(way[node1]+way[node])%mod;
                }
                if(dist[node1]>cur_d+dis){
                    pq.add(new long[]{node1,cur_d+dis});
                    dist[node1]=cur_d+dis;
                    way[node1]=way[node];
                }
            }
        }
       return way[n-1];
    }
}