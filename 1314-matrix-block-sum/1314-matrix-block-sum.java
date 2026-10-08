class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] result = new int[n][m];

        //BRUT FORCE

        // for(int i =0;i<n;i++){
        //     for(int j =0; j< m;j++){

        //         int sum =0;

        //         for(int a = i-k ; a <=i + k ;a++){
        //             for(int b = j -k ; b <=j +k ; b++){

        //                 if(a>=0 && b>=0 && a<n && b<m){
        //                     sum+=mat[a][b];
        //                 }
        //             }
        //         }
        //     result[i][j] = sum;
        //     }
        // }
        // return result;

        int[][] sum = new int[n+1][m+1];

        for(int i =1; i <=n;i++){
            for(int j =1; j <=m;j++){
                sum[i][j] = mat[i-1][j-1] + sum[i-1][j]+sum[i][j-1]  - sum[i-1][j-1];
            }
        }
        for(int i =0;i< n;i++){
            for(int j =0 ;j<m;j++){

               int  r1 = Math.max(0,i -k);
                int c1 = Math.max(0,j -k);

                int r2 = Math.min(i+k,n-1);
                int c2 = Math.min(j+k,m-1);

                r1++;
                r2++;
                c1++;
                c2++;

                result[i][j] = sum[r2][c2] - sum[r1 -1][c2] - sum[r2][c1-1] +sum[r1-1][c1-1];
            }
        }
        return result;
    }
}