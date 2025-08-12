class DisJoint{
    int[] par;
    int[] size;
    int[] rank;
    DisJoint(int n){
        par=new int[n];
        size=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    int findpar(int node){
        if(node==par[node]) return node;
        par[node]=findpar(par[node]);
        return par[node];
    }
    void ubr(int n1,int n2){
        n1=findpar(n1);
        n2=findpar(n2);
        if(n1==n2)  return;
        if(rank[n1]<rank[n2]){
            par[n1]=n2;
        }
        else if(rank[n1]>rank[n2]){
            par[n2]=n1;
        }
        else{
            par[n2]=n1;
            rank[n1]++;
        }
    }
    void ubs(int n1,int n2){
        n1=findpar(n1);
        n2=findpar(n2);
        if(n1==n2)  return;
        if(size[n1]<size[n2]){
            par[n1]=n2;
            size[n2]=size[n1]+size[n2];
        }
        else if(size[n1]>size[n2]){
            par[n2]=n1;
            size[n1]=size[n1]+size[n2];
        }
        else{
            par[n2]=n1;
            size[n2]=size[n1]+size[n2];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        List<List<String>> list = new ArrayList<>();
        List<List<String>> tlist = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        DisJoint ds = new DisJoint(acc.size());
        for(int i=0;i<acc.size();i++){                      // assigning gmail to groups
            for(int j=1;j<acc.get(i).size();j++){
                String temp=acc.get(i).get(j);
                if(map.containsKey(temp)){
                    ds.ubr(i,map.get(temp));
                    continue;
                }
                map.put(temp,i);                
            }
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<acc.size();i++)   tlist.add(new ArrayList<>());
        for(int i=0;i<acc.size();i++){              //  adding gmail to corresponding groups
            for(int j=1;j<acc.get(i).size();j++){
                String temp=acc.get(i).get(j);
                if(set.contains(temp))  continue;
                set.add(temp);
                tlist.get(ds.findpar(map.get(temp))).add(temp);
            }
        }
        System.out.print(tlist);
        for(int i=0;i<acc.size();i++){
            if(tlist.get(i).size()==0)    continue;
            List<String> te = tlist.get(i);
            Collections.sort(te);
            // String st=acc.get(i).get(j);
            te.add(0,acc.get(i).get(0));
            list.add(te);
        }

        return list;
    }
}