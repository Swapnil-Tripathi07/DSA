class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0 ; i<n ; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        return minTotal(triangle,0,0,dp);
    }


    public int minTotal(List<List<Integer>> list , int i , int j,int[][] dp){
        if(i>list.size()-1 || j>list.get(i).size()-1){
            return 0;
        }

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        //At each index you have two choices taht is left bottom or right bottom.
        int left = list.get(i).get(j) + minTotal(list,i+1,j,dp);
        int right =  list.get(i).get(j) + minTotal(list,i+1,j+1,dp);
        dp[i][j] = Math.min(left,right);
        return dp[i][j];

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna