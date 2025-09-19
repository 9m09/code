class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] last = {-1, -1, -1}; 
        
        int count = 0;

        for (int r = 0; r < n; r++) {
            last[s.charAt(r) - 'a'] = r;

            if (last[0] != -1 && last[1] != -1 && last[2] != -1) {
                int l = Math.min(last[0], Math.min(last[1], last[2]));
                count += l + 1; 
            }
        }
        return count;
    }
}
