class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int height = grid.length;
        int width = grid[0].length;
        
        Set<ArrayList<String>> set = new HashSet<>();
        

        for(int i =0;i<height;i++){
            for(int j =0;j<width;j++){
                ArrayList<String> list = new ArrayList<>();
               if( grid[i][j] == 'L')
               set.add(dfs(i,j,list,grid,i,j));
                
            }
        }
        return set.size();
    }
    public static ArrayList<String> dfs(int row,int col,ArrayList<String> list,char[][] grid,int brow,int bcol){
        
        int height = grid.length;
        int width = grid[0].length;
        
        if(row<0||col<0|| row >=height||col >= width|| grid[row][col] !='L') return list;
        
        String arr = (row-brow) + "," +(col-bcol);
        list.add(arr);
        grid[row][col]='W';
        
        dfs(row-1,col,list,grid,brow,bcol);
        dfs(row+1,col,list,grid,brow,bcol);
        dfs(row,col-1,list,grid,brow,bcol);
        dfs(row,col+1,list,grid,brow,bcol);
        
        return list;
    }
}