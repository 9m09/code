class Solution {
    HashMap<Integer,char[]> mapped ;
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0)  return list;
        mapped =  new HashMap<>();
        mapped.put(2, new char[]{'a', 'b', 'c'});
        mapped.put(3, new char[]{'d', 'e', 'f'});
        mapped.put(4, new char[]{'g', 'h', 'i'});
        mapped.put(5, new char[]{'j', 'k', 'l'});
        mapped.put(6, new char[]{'m', 'n', 'o'});
        mapped.put(7, new char[]{'p', 'q', 'r', 's'});
        mapped.put(8, new char[]{'t', 'u', 'v'});
        mapped.put(9, new char[]{'w', 'x', 'y', 'z'});


        generate(digits,list,0,new StringBuilder());
        return list;
    }
    void generate(String digits,List<String> list , int index,StringBuilder st){
        if(index==digits.length()){
            String str=st.toString();
            list.add(str);
            return;
        }
        // int num=Integer.valueOf( digits.charAt(index) );
        int num = digits.charAt(index) - '0';
        char[] ch =mapped.get(num);
        for(int i=0;i<ch.length;i++){
            st.append(ch[i]);
            generate(digits,list,index+1,st);
            st.deleteCharAt(st.length()-1);  
        }
    }
}