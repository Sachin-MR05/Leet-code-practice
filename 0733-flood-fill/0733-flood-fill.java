class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        

        dfs(image,sr,sc,color,originalColor);

        return image;
    }
    static void dfs(int[][] image, int sr, int sc, int color,int originalColor){
        int length = image.length;
        int width = image[0].length;
        if(sr<0||sc<0||sr>=length||sc>=width||image[sr][sc]!=originalColor) return;

        image[sr][sc]=color;

        dfs(image,sr-1,sc,color,originalColor);
        dfs(image,sr+1,sc,color,originalColor);
        dfs(image,sr,sc+1,color,originalColor);
        dfs(image,sr,sc-1,color,originalColor);
    }
}

// import java.util.*;
// class cell{
//     int row;
//     int col;
//     cell(int row,int col){
//         this.row =row;
//         this.col = col;
//     }
// }
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         Queue<cell> q= new LinkedList<>();
//         int originalcolour = image[sr][sc];
//         if (originalcolour == color) {
//             return image;
//         }
//         int length = image.length;
//         int bredth = image[0].length;
//         int[] delrow = {-1,+1,0,0};
//         int[] delcol = {0,0,-1,+1};

//         q.add(new cell(sr,sc));
//         image[sr][sc] = color;
//         while(!q.isEmpty()){
//             cell c = q.poll();
            
//             for(int i=0;i<4;i++){
//                 int row = c.row + delrow[i];
//                 int col = c.col + delcol[i];
            
//             if(row>=0&&col>=0&&row<length&&col<bredth && image[row][col]==originalcolour){
//                 image[row][col]=color;
//                 q.add(new cell(row, col));
//             }
//             }
//         }
//     return image;    
//     }
// }