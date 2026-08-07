import java.util.*;
class cell{
    int row;
    int col;
    cell(int row,int col){
        this.row =row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<cell> q= new LinkedList<>();
        int originalcolour = image[sr][sc];
        if (originalcolour == color) {
            return image;
        }
        int length = image.length;
        int bredth = image[0].length;
        int[] delrow = {-1,+1,0,0};
        int[] delcol = {0,0,-1,+1};

        q.add(new cell(sr,sc));
        image[sr][sc] = color;
        while(!q.isEmpty()){
            cell c = q.poll();
            
            for(int i=0;i<4;i++){
                int row = c.row + delrow[i];
                int col = c.col + delcol[i];
            
            if(row>=0&&col>=0&&row<length&&col<bredth && image[row][col]==originalcolour){
                image[row][col]=color;
                q.add(new cell(row, col));
            }
            }
        }
    return image;    
    }
}