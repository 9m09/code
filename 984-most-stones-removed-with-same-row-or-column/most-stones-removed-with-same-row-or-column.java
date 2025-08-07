class Disjoint{
    int[] parent;
    int[] rank;
    int[] size;
    Disjoint(int n){
        parent = new int[n];
        rank=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findUPar(parent[node]); 
        return parent[node];
    }
    public void ubr(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
    public void ubs(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v]=size[ulp_u]+size[ulp_v];
        } else if (size[ulp_v] < size[ulp_u]) {
            size[ulp_u]=size[ulp_u]+size[ulp_v];
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u]=size[ulp_u]+size[ulp_v];
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int con=0;
        int r=Integer.MIN_VALUE;
        int c=Integer.MIN_VALUE;
        for(int i=0;i<stones.length;i++){
            r=Math.max(r,stones[i][0]);
            c=Math.max(c,stones[i][1]);
        }
        Disjoint ds = new Disjoint(r+c+2);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<stones.length;i++){
            int col=r+1+stones[i][1];
            ds.ubs(stones[i][0],col);
            set.add(col);
            set.add(stones[i][0]);
        }
        
        for(int i:set){
            if(ds.parent[i]==i) con++;
        }
        return stones.length-con;
    }
}