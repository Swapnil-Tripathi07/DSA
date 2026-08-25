class Solution {
    public int climbStairs(int n) {
    
       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);
       return climb(n,0,dp);
        
    }

    private int climb(int n , int count,int[] dp){
        if(count ==  n){
            return 1;
        }
        if(count > n){
            return 0;
        }
        if(dp[count] != -1){
            return dp[count];
        }
        int oneStep = climb(n,count+1,dp);
        int twoStep = climb(n,count+2,dp);
        dp[count] = oneStep+twoStep;
        return dp[count];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna