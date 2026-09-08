class Solution {

    //DP
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;
        int[][] dp = new int[n][n];

        for(int i = 0 ; i<n ; i++){
            Arrays.fill(dp[i],-1);
        }

        int i = n-1;
        int ans = Integer.MAX_VALUE;
        
        for (int j=0; j<n; j++){
            ans = Math.min(ans, solve(i,j,grid,dp));
        }
        return ans;
    }

    public static int solve(int i, int j , int grid[][],int[][] dp){
        int n = grid.length;
        if(i==0) return grid[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for(int col=0; col<n; col++){
            if(j!=col){
                int path = grid[i][j] + solve(i-1, col, grid,dp);
                ans = Math.min(ans,path);
                dp[i][j] = ans;

            }
        }
        return dp[i][j];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna