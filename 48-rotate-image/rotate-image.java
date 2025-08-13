class Solution {
    public void rotate(int[][] matrix) {
        int s=matrix.length;
        for(int r=0;r<s;r++){           // transpose
            for(int c=r+1;c<s;c++){
                int temp=matrix[r][c];
                matrix[r][c]=matrix[c][r];
                matrix[c][r]=temp;
            }
        }
        for(int r=0;r<s;r++){      //reverse each row
            int k=s-1;
            for(int i=0;i<s/2;i++){
                int temp=matrix[r][i];
                matrix[r][i]=matrix[r][k];
                matrix[r][k]=temp;
                k--;
            }
        } 
    }
}