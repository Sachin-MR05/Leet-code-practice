class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length==0) return 0;
        
    int height = grid.length;
    int width = grid[0].length;

    Queue<int[]> q = new LinkedList<>();
    int freshOrange =0; 
    for(int i=0;i<height;i++){
        for(int j =0;j<width;j++){
            if(grid[i][j]==2){
                q.offer(new int[]{i,j});
            }else if(grid[i][j]==1){
                freshOrange++;
            }
        }        
    }
    if(freshOrange==0 ) return 0;
    if(q.size()<=0) return -1;

    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    int time = 0;
    while(!q.isEmpty()){
        int size = q.size();
        boolean rotten = false;

        
        for(int i =0;i<size;i++){
            int[] arr = q.poll();
            int crow = arr[0];
            int ccol = arr[1];


            for(int[] dir : direction){
                int row = crow+dir[0];
                int col = ccol+dir[1];

                if(row>=0 && col>=0 && row <height && col <width && grid[row][col]==1){
                    grid[row][col] = 2;
                    q.offer(new int[]{row,col});
                    freshOrange--;
                    rotten = true;
                }
            }
        }
    if(rotten)
    time++;
    }
    return (freshOrange ==0) ? time : -1;
    }
}