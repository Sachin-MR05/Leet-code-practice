class Solution {
    public void fill(char[][] grid) {
        // Code here
        int height = grid.length;
        int width = grid[0].length;
        int[][] visit = new int[height][width]; 
        for(int i =0;i<height;i++){
            if(grid[i][0]=='O' && visit[i][0]==0){
                dfs(grid,visit,i,0,height,width);
            }
            if(grid[i][width-1] == 'O' && visit[i][width-1]==0){
                dfs(grid,visit,i,width-1,height,width);
            }
        }
        for(int i =0;i<width;i++){
            if(grid[0][i]=='O' && visit[0][i]==0){
                dfs(grid,visit,0,i,height,width);
            }
            if(grid[height-1][i] == 'O' && visit[height-1][i] == 0){
                dfs(grid,visit,height-1,i,height,width);
            }
        }
        
        for(int i =0;i<height;i++){
            for(int j =0;j<width;j++){
                if(visit[i][j]==0 && grid[i][j]=='O')
                grid[i][j] ='X';
            }
        }
    }
    public static void dfs(char[][] grid,int[][] visit,int row,int col, int height, int width){

        if(row>=height || col >=width || row <0 || col <0|| grid[row][col]!='O'|| visit[row][col]!=0 )
        return;
        
        visit[row][col] =1;

        
        dfs( grid,visit,row+1,col,height,width);
        dfs( grid,visit,row-1,col,height,width);
        dfs( grid,visit,row,col+1,height,width);
        dfs( grid,visit,row,col-1,height,width);
    }
}
