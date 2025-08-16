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
    public int fup(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = fup(parent[node]); 
        return parent[node];
    }
    public void ubr(int u, int v) {
        int ulp_u = fup(u);
        int ulp_v = fup(v);
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
        int ulp_u = fup(u);
        int ulp_v = fup(v);
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
        Disjoint r = new Disjoint(stones.length);
        // Disjoint c = new Disjoint(stones.length);
        HashMap<Integer,Integer> rmap = new HashMap<>();
        HashMap<Integer,Integer> cmap = new HashMap<>();

        rmap.put(stones[0][0],0);
        cmap.put(stones[0][1],0);
        for(int i=1;i<stones.length;i++){
            if(rmap.containsKey(stones[i][0])&&cmap.containsKey(stones[i][1])){
                int pr=r.fup(rmap.get(stones[i][0]));
                int pc=r.fup(cmap.get(stones[i][1]));
                r.ubr(pr,pc);
                // c.ubr(pr,pc);
                r.ubr(pr,i);
                // c.ubr(pr,i);
            }
            else if(rmap.containsKey(stones[i][0])){
                int pr=r.fup(rmap.get(stones[i][0]));
                r.ubr(pr,i);
                // c.ubr(pr,i);
                cmap.put(stones[i][1],i);
            }
            else if(cmap.containsKey(stones[i][1])){
                int pc=r.fup(cmap.get(stones[i][1]));
                r.ubr(pc,i);
                // c.ubr(pc,i);
                rmap.put(stones[i][0],i);
            }
            else{
                rmap.put(stones[i][0],i);
                cmap.put(stones[i][1],i);
            }
        }
        int rem=0;
        for(int i=0;i<stones.length;i++){
            if(i!=r.fup(i))   rem++;
        }
        return rem;

        // int con=0;
        // int r=Integer.MIN_VALUE;
        // int c=Integer.MIN_VALUE;
        // for(int i=0;i<stones.length;i++){
        //     r=Math.max(r,stones[i][0]);
        //     c=Math.max(c,stones[i][1]);
        // }
        // Disjoint ds = new Disjoint(r+c+2);
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0;i<stones.length;i++){
        //     int col=r+1+stones[i][1];
        //     ds.ubs(stones[i][0],col);
        //     set.add(col);
        //     set.add(stones[i][0]);
        // }
        
        // for(int i:set){
        //     if(ds.parent[i]==i) con++;
        // }
        // return stones.length-con;
    }
}