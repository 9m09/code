class Solution {

    public boolean isMatch(String s, String p) {
        // return true;
        // if(s.length()==0)   return true;
        // if(p.length()==0)   return false;
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return help(s,0,p,0,dp);
    }

    boolean help(String s,int is,String p,int ip,Boolean[][] dp){

        if(is==s.length()) {
            for(int i=ip;i<p.length();i++){
                if(p.charAt(i)!='*'||p.charAt(i)=='?')    return false;
            }
            return true;
        }

        if(ip==p.length())  return is==s.length();

        if(dp[is][ip]!=null)    return dp[is][ip];

        if(p.charAt(ip)=='*'){
            // if(ip!=p.length()-1 ){
            //     int c=is;
            //     for(int i=s.length()-1;i>=is;i--){
            // if(s.charAt(i)==p.charAt(ip+1) ||p.charAt(ip+1)=='?'){
            //             c=i;
            //             break;
            //         }
            //     }
            boolean r1= help(s,is,p,ip+1,dp);   //take empty char
            boolean r2= help(s,is+1,p,ip,dp);   // take non-empty char
            return dp[is][ip]=r1||r2;
            
            // else    return true;
        }   
        // if(p.charAt(ip)=='?')   help(s,s+1,p,p+1,dp);
        if( s.charAt(is)==p.charAt(ip) || p.charAt(ip)=='?') 
            return dp[is][ip]=help(s,is+1,p,ip+1,dp);

        return dp[is][ip]=false;
    }
}