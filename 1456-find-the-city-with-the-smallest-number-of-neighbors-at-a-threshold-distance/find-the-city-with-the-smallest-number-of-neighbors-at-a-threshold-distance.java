class Solution {
    public int findTheCity(int n, int[][] edges, int dth) {

        int[][] adj= new int[n][n];
        
        for(int[] i:adj){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++)   adj[i][i]=0;     //  making zero distance from a node to itself

        for(int i=0;i<edges.length;i++){
                adj[ edges[i][0] ][ edges[i][1] ]=edges[i][2];
                adj[ edges[i][1] ][ edges[i][0] ]=edges[i][2];
        }    

        for(int via=0;via<adj.length;via++){
            for(int i=0;i<adj.length;i++){
                for(int j=0;j<adj.length;j++){
                    if(
                        adj[i][j]>adj[i][via]+adj[via][j]
                        &&adj[i][via]!=Integer.MAX_VALUE
                        &&adj[via][j]!=Integer.MAX_VALUE
                    ){
                        adj[i][j]=adj[i][via]+adj[via][j];
                    }
                }
            }   
        }
        // int vis=Integer.MAX_VALUE;
        int node=0;
        int dis=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            // int vi=0;
            int di=0;
            for(int j=0;j<n;j++){
                if(adj[i][j]==Integer.MAX_VALUE)    continue;
                if(adj[i][j]<=dth)  di++;
            }
            if(dis>=di){
                dis=di;
                node=i;
            }
            
        }

        return node;
    }
}