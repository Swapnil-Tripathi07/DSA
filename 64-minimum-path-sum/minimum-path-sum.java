class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[i].length ; j++ ){
                dp[i][j] = -1;
            }
        }
        int path = minimumPath(grid , dp , grid.length-1, grid[0].length -1);
        return path;
    }

    public int minimumPath(int[][] grid , int[][] dp , int i , int j){
        if(i==0 && j==0) return grid[i][j];

        if(i<0 || j<0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int up = minimumPath(grid,dp,i-1,j);
        int left = minimumPath(grid,dp,i,j-1);

        dp[i][j] = grid[i][j] + Math.min(up,left);
        return dp[i][j];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna