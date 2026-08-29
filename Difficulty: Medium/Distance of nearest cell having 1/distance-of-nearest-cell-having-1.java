class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(grid.length);
        for(int i=0;i<grid.length;i++){
            list.add(new ArrayList<Integer>(grid[0].length));
        }
        
        int height = grid.length;
        int width = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        int zero = 0;
        int distance =1;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j});
                }
                else{
                    zero++;
                }
            }
        }
        //if(nearest == null || g)
        
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        distance +=1;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i =0;i<size;i++){
                int[] arr = q.poll();
                int crow = arr[0];
                int ccol = arr[1];
                
                for(int[] direction : directions){
                    int row = crow+direction[0];
                    int col = ccol+direction[1];
                    
                    if(row <height && col < width && row>=0 && col >=0 && grid[row][col]==0){
                        grid[row][col]=distance;
                        q.add(new int[]{row,col});

                    }
                }
            }
            distance++;
        }
        for(int i = 0;i<height;i++){
            for(int j =0;j<width;j++){
                grid[i][j]-=1;
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for (int i = 0; i < height; i++) {
        ArrayList<Integer> rowList = new ArrayList<>();
        for (int j = 0; j < width; j++) {
            rowList.add(grid[i][j]);
        }
        result.add(rowList);
    }
    return result;
    }
}