class Solution {
    public void setZeroes(int[][] m) {
        int r=m.length;
        int c=m[0].length;
        // int flagr=0,flagc=0;
        // for(int j=1;j<c;j++){
        //     if(m[0][j]==0)  flagr=1;
        // }
        // for(int i=0;i<r;i++){
        //     if(m[i][0]==0)  flagc=1;
        // }
        int flagr=0,flagc=0;
        for(int i=0;i<r;i++){
            if(m[i][0]==0)  flagr=1;
        }
        for(int j=0;j<c;j++){
            if(m[0][j]==0)  flagc=1;
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(m[i][j]==0){
                    m[0][j]=0;
                    m[i][0]=0;
                }
            }
        }
        for(int j=1;j<c;j++){
            if(m[0][j]==0){
                for(int k=0;k<r;k++){
                    m[k][j]=0;
                }
            }
        }
        for(int i=1;i<r;i++){
            if(m[i][0]==0){
                for(int k=0;k<c;k++){
                    m[i][k]=0;
                }
            }
        }
        // System.out.println(flagr);
        if(flagr==1){
            for(int i=0;i<r;i++){
                m[i][0]=0;
            }
        }
        if(flagc==1){
            for(int j=0;j<c;j++){
                m[0][j]=0;
            }
        }
        // if(flagr==1){
        //     for(int )
        // }
        // if(flagc==1){

        // }
        // int r=matrix.length;
        // int c=matrix[0].length;
        // int[][] arr = new int[r][c];
        // for(int i=0;i<r;i++){
        //     arr[i]=matrix[i].clone();
        // }
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         if(matrix[i][j]==0){
        //             for(int k =0;k<r;k++){
        //                 arr[k][j]=0;
        //             }
        //             for(int l=0;l<c;l++){
        //                 arr[i][l]=0;
        //             }
        //         }
        //     }
        // }   
        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         matrix[i][j] = arr[i][j];
        //     }
        // }
        
    }
}