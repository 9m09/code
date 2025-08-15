// User function Template for Java
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
    boolean isvalid(int r,int c,int s){
        return r>-1 && c>-1 && r<s && c<s;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int size=0;
        Disjoint ds = new Disjoint(grid.length*grid.length);

        for(int r=0;r<grid.length;r++){     // adding all the 1 nodes together
            for(int c=0;c<grid.length;c++){
                if(grid[r][c]==0)   continue;
                int[] dr = {-1, 1, 0, 0};
                int[] dc = {0, 0, -1, 1};
                for (int dir = 0; dir < 4; dir++) {
                    int newr = r + dr[dir];
                    int newc = c + dc[dir];
                    if (isvalid(newr,newc,n)&&grid[newr][newc]==1) {
                        int num1 = (n * r) + c;
                        int num2 = (n * newr) + newc;
                        // if (ds.findUPar(num1) != ds.findUPar(num2)) {
                            ds.ubs(num1, num2); 
                        // }
                    }
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col <n; col++) {
                if (grid[row][col] == 1) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();  // use hashset to avoid adding same node 
                // by adding ultimate parents of neighbouring node so to avoid adding node of same group
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isvalid(newr, newc, n)) {
                        if (grid[newr][newc] == 1&&!components.contains(newr*n+newc)) {
                            components.add(ds.findUPar(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += ds.size[parents];
                }
                size = Math.max(size, sizeTotal + 1);
            }
        }

        for (int cellNo = 0; cellNo < n * n; cellNo++) { // if there are compponents having bigger       
                                                    // size and not been covered by converting zero to one
            size = Math.max(size, ds.size[ds.findUPar(cellNo)]);
        }


        return size;    
    }
}