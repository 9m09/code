class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {

        if(s1.length()<s2.length()){
            String t=s1;
            s1=s2;
            s2=t;
        }


        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    
        if(dp[n][m]==s2.length())  return s1;
        for(int[] i: dp)    System.out.println(Arrays.toString(i));

        int r=dp[n][m];
        String str = "";
        int i=s1.length(),j=s2.length();
        while(r>0){ 
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                r--;
                str=s1.charAt(i-1)+str;
                i--;
                j--;
            }
            else{
                int up=0,left=0;
                if(i-1>-1)   up=dp[i-1][j];
                if(j-1>-1)   left=dp[i][j-1];
                if(up>left){
                    // if(j-1>-1)
                    System.out.println(s1.charAt(j-1));
                    str=s1.charAt(i-1)+str;
                    i--;
                }
                else{
                    // if(i-1>-1)
                    str=s2.charAt(j-1)+str;
                    j--;
                }
               
            }
        }
        while(i>0){
            str=s1.charAt(i-1)+str;
            i--;
        }
        while(j>0){
            str=s2.charAt(j-1)+str;
            j--;
        }

        return str;    
    }
    
}