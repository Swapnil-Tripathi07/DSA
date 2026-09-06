class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1){ //Means at very first index 
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0 ; i<grid.length; i++){
            for(int j = 0 ; j<grid[0].length ; j++ ){
                dp[i][j] = -1;
            }
        }

        return numberPath(dp,0,0,grid.length-1, grid[0].length-1,grid);

    }

    public int numberPath(int[][] dp,int i , int j , int m , int n , int[][] grid){
        if(i>m || j>n){
            return 0;
        }

        if(grid[i][j] == 1) return 0;   // Here is an obstacle.

        if(i==m && j==n){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = numberPath(dp,i+1,j,m,n,grid);
        int down = numberPath(dp,i,j+1,m,n,grid);

        dp[i][j] = right+down;
        return dp[i][j];
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna