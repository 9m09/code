class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> wl = new HashSet<>(); // wl=wordList
        for(String s:wordList)  wl.add(s);

        if(!wl.contains(endWord))   return 0;

        char[] ch = new char[26];
        for(int i=0;i<26;i++)   ch[i]=(char)('a'+i);

        HashSet<String> vi = new HashSet<>();   // to check if word already included in the path or not

        Queue<String> qu = new LinkedList<>();
        qu.add(beginWord);
        vi.add(beginWord);
        int level=1;
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0;i<size;i++){
                String temp = qu.poll();
                for(int p=0;p<temp.length();p++){
                    for(int alpha=0;alpha<26;alpha++){
                        StringBuilder tt = new StringBuilder(temp);
                        tt.setCharAt(p,ch[alpha]);
                        String check = tt.toString();
                        if (check.equals(endWord)) return level + 1;
                        if(wl.contains(check)&&!vi.contains(check)){
                        System.out.println(tt);
                            qu.add(check);
                            vi.add(check);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
} 