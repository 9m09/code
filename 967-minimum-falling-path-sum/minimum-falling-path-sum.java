class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] prev = new int[m];
        int[] curr = new int[m];

        for (int j = 0; j < m; j++) prev[j] = mat[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = prev[j];
                int ld = (j > 0) ? prev[j - 1] : Integer.MAX_VALUE;
                int rd = (j < m - 1) ? prev[j + 1] : Integer.MAX_VALUE;
                curr[j] = Math.min(up, Math.min(ld, rd)) + mat[i][j];
            }
            prev = curr.clone();
        }

        int min = Integer.MAX_VALUE;
        for (int val : prev) min = Math.min(min, val);
        return min;
    }
}
