class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[n][m];

        for(int row = 0 ; row<n ; row++){
            for(int col = 0 ;col<m ; col++){
                if(visited[row][col] == false && grid[row][col] == '1'){
                    bfs(row,col,visited,grid);  // hum bfs usi pe apply karenge jo unvisited hoga and cell 1 hoga.
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(int i , int j , boolean[][] visited , char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        int[] dX = {-1,0,1,0};  //up , right , down , left
        int[] dY = {0,1,0,-1};

        while(!q.isEmpty()){

            int[] curr = q.poll();
            int x = curr[0];   // The position , currently where we are. i(row)
            int y = curr[1];          //j(col)


            for(int k = 0 ; k<4 ; k++){
                int newX = x + dX[k];   //New position where we want to move. new i
                int newY = y + dY[k];   // new j.

                if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY] == '1' && visited[newX][newY] == false){
                    q.add(new int[]{newX,newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna