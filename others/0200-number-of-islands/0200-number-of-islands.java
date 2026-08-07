class Solution {
    public int numIslands(char[][] grid) {
       if(grid.length==0){
        return 0;
       }
       int row = grid.length;
       int col = grid[0].length;
       int island = 0;
       for(int r =0;r<row;r++){
        for(int c = 0;c<col;c++){
            if(grid[r][c]=='1'){
                island++;
                dfs(r,c,grid);
            }
        }
       }
       return island;
    }
    static void dfs(int row,int col,char[][] grid){
        int c = grid[0].length;
        int r = grid.length;

        if(row<0||row>=r||col<0||col>=c||grid[row][col]=='0') return;


        grid[row][col]='0';
        dfs(row+1,col,grid);
        dfs(row-1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
    }
}