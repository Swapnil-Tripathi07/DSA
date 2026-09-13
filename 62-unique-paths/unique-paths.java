// class Solution {

//DP

//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int i = 0 ; i<m; i++){
//             for(int j = 0 ; j<n ; j++ ){
//                 dp[i][j] = -1;
//             }
//         }

//         return numberPath(dp,0,0,m-1,n-1);

//     }


//     // This DP stores the total no. of ways to reach at the end

//     public int numberPath(int[][] dp,int i , int j , int m , int n){
//         if(i>m || j>n){
//             return 0;
//         }
//         if(i==m && j==n){
//             return 1;
//         }

//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }

//         int right = numberPath(dp,i+1,j,m,n);
//         int down = numberPath(dp,i,j+1,m,n);

//         dp[i][j] = right+down;
//         return dp[i][j];
//     }
// }



class Solution{


    //  TABULATION

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // Last row
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        // Last column
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        // Fill from bottom-right to top-left
        for (int i = m - 2; i >= 0; i--) {

            for (int j = n - 2; j >= 0; j--) {

                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna