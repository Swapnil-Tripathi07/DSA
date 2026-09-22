class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0 ; i<coins.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(coins,amount,0,0,dp);
    }

    public int solve(int[] coins , int amount , int i , int sum,int[][] dp){
        if(sum == amount){
            return 1;
        }
        if(sum>amount || i>coins.length-1){
            return 0;
        }

        if(dp[i][sum] != -1){
            return dp[i][sum];
        }

        int take = solve(coins,amount,i,sum+coins[i],dp);
        int skip  = solve(coins,amount,i+1,sum,dp);
        return dp[i][sum] = take+skip;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna