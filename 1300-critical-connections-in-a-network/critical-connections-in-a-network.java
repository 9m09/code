class Solution {
    int timer=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> com) {
                List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        for(int i=0;i<com.size();i++){
            adj.get(com.get(i).get(0)).add(com.get(i).get(1));
            adj.get(com.get(i).get(1)).add(com.get(i).get(0));
        }   
        List<List<Integer>> con = new ArrayList<>();
        int[] time = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        dfs(0,vis,time,low,adj,-1,con);
        return con;
    }

    void dfs(int start,boolean[] vis,int[] time,int[] low,List<List<Integer>> adj,int parent,List<List<Integer>> con){
        vis[start]=true; 
        timer++;
        low[start]=timer;
        time[start]=timer;
        for(int i=0;i<adj.get(start).size();i++){
            if(parent==adj.get(start).get(i))    continue;
            if(!vis[adj.get(start).get(i)]){
                dfs(adj.get(start).get(i),vis,time,low,adj,start,con);
                
            }
            // if(vis[adj.get(start).get(i)]&&adj.get(start).get(i)!=parent){
                low[start]=Math.min(low[adj.get(start).get(i)],low[start]);
            // }
        } 
                if(parent==-1)  return;
                if(time[parent]<low[start]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);list.add(parent);
                    con.add(list);  
                }
                low[parent]=Math.min(low[parent],low[start]);
    }
}
