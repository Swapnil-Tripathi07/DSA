class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);

        int first =  solve(cost,0,dp);
        int second = solve(cost,1,dp);
        return Math.min(first,second);
    }

    private int solve(int[] cost, int i,int[] dp){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int one = cost[i] + solve(cost,i+1,dp);
        int two = cost[i] + solve(cost,i+2,dp);
        dp[i] = Math.min(one,two);
        return dp[i];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna