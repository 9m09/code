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

    void dfs(int start,boolean[] vis,int[] time,int[] low,List<List<Integer>> adj,int parent,               List<List<Integer>> con){
        vis[start]=true; 
        timer++;
        low[start]=timer;
        time[start]=timer;
        for(int i=0;i<adj.get(start).size();i++){
            if(adj.get(start).get(i)==parent)   continue;
            if(!vis[adj.get(start).get(i)]){
                dfs(adj.get(start).get(i),vis,time,low,adj,start,con);
                low[start]=Math.min(low[start],low[adj.get(start).get(i)]);
                if(time[start]<low[adj.get(start).get(i)]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(adj.get(start).get(i));
                    con.add(list);
                }
            }
            else    low[start]=Math.min(low[start],low[adj.get(start).get(i)]);
        } 
             
    }
}
