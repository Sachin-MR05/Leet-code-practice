class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] result = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j =0; j< m;j++){

                int sum =0;

                for(int a = i-k ; a <=i + k ;a++){
                    for(int b = j -k ; b <=j +k ; b++){

                        if(a>=0 && b>=0 && a<n && b<m){
                            sum+=mat[a][b];
                        }
                    }
                }
            result[i][j] = sum;
            }
        }
        return result;
    }
}