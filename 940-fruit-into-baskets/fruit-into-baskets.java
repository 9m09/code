class Solution {
    public int totalFruit(int[] f) {
        HashMap<Integer,Integer> map = new HashMap<>(); // STORING last occurig INDEX OF TREE
        if(f.length==1) return 1;
        int t1=f[0];
        int max=Integer.MIN_VALUE;
        int l=0,r=0;

        while(r<f.length&&f[r]==t1){
            r++;
        }
        if(r>=f.length) return f.length;
        map.put(t1,r-1);
        // map.put(t2,r);
    
        int t2=f[r];
        // max=Math.max(max,r-l+1);

        while(r<f.length){
            if(f[r]!=t1&&f[r]!=t2){
                if(f[r-1]==t1){
                    l=map.get(t2)+1;
                    t2=f[r];
                    map.put(t2,r);
                }
                else{
                    l=map.get(t1)+1;
                    t1=f[r];
                    map.put(t1,r);
                }
            }
            else{
                if(f[r]==t1){
                    map.put(t1,r);
                }
                else{
                    map.put(t2,r);
                }
            }
            max=Math.max(max,r-l+1);
            r++;
        }

        return max;
    }
}