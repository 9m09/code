class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] arr = new char[n][n];
        queen(0,arr,list,n);
        return list;
    }
    void queen(int index,char[][]arr,List<List<String>> list,int n){
        if(index==n){
            List<String> tl = new ArrayList<>(); 
            for(int i=0;i<n;i++){
                StringBuilder str = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(arr[i][j]=='q') str.append('Q');
                    else str.append('.');
                }
                String st = str.toString();
                tl.add(st);   
            }
            list.add(tl);
        }

        for(int c=0;c<n;c++){
            if(valid(index,c,arr)){
                arr[index][c]='q';
                queen(index+1,arr,list,n);
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