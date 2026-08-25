class Solution {

    // DP SOLUTION
    // public int climbStairs(int n) {
    
    //    int[] dp = new int[n+1];
    //    Arrays.fill(dp,-1);
    //    return climb(n,0,dp);
        
    // }

    // private int climb(int n , int count,int[] dp){
    //     if(count ==  n){
    //         return 1;
    //     }
    //     if(count > n){
    //         return 0;
    //     }
    //     if(dp[count] != -1){
    //         return dp[count];
    //     }
    //     int oneStep = climb(n,count+1,dp);
    //     int twoStep = climb(n,count+2,dp);
    //     dp[count] = oneStep+twoStep;
    //     return dp[count];
    // }

    //TABULATION
    public int climbStairs(int n){
        if(n<=2){
            return n;
        }

        int[] tabulation = new int[n+1];
        tabulation[0] = 0;
        tabulation[1] = 1;
        tabulation[2] = 2;
        for(int i = 3 ; i<=n ; i++){
            tabulation[i] = tabulation[i-1] + tabulation[i-2]; 
        }
        return tabulation[n];

    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna