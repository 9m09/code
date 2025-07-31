class Solution {
    public int totalNQueens(int n) {
        int count[]={0};
        char[][] arr = new char[n][n];
        queen(0,arr,count,n);
        return count[0];
    }

    void queen(int index,char[][]arr,int[] count,int n){
        if(index==n)    count[0]++;

        for(int c=0;c<n;c++){
            if(valid(index,c,arr)){
                arr[index][c]='q';
                queen(index+1,arr,count,n);
                arr[index][c]='.';
            }
        }
    }

    boolean valid(int r,int c,char[][] arr){

        for(int i=r-1;i>=0;i--){
            if(arr[i][c]=='q')  return false;
        }
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(arr[i][j]=='q')  return false;
        }
        for(int i=r-1,j=c+1;i>=0&&j<arr.length;i--,j++){
            if(arr[i][j]=='q')  return false;
        }

        return true;
    }
}