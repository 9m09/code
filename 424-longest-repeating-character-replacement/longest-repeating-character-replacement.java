class Solution {
    public int characterReplacement(String s, int k) {
        int max=Integer.MIN_VALUE;
        int maxf=0;
        int[] alp=new int[26];        
        int l=0;
        for(int r=0;r<s.length();r++){
            char c= s.charAt(r);
            alp[c-'A']++;
            maxf=Math.max(maxf,alp[c-'A']);
                while(r-l+1-maxf>k){
                    alp[s.charAt(l)-'A']--;
                    maxf=0;
                    for(int i=0;i<26;i++){
                        maxf=Math.max(maxf,alp[i]);
                    }
                    l++;
                }
            max=Math.max(max,r-l+1);
        }
        return max;        
    }
}