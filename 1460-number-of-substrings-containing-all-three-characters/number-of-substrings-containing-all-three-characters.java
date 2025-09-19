class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r),r);
            if(map.size()==3){
                int l=Math.min( Math.min(map.get('a'),map.get('b')),map.get('c') );
                System.out.println(l+":"+r);
                count=count+l+1;
            }
        }

        return count;    
    }
}