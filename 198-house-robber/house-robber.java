class Solution {

    // MEMOIZATION
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return houseRob(nums,0,dp);
    }

    public int houseRob(int[] arr , int i, int[] dp){
        if(i > arr.length-1){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int rob = arr[i] + houseRob(arr,i+2,dp);
        int skip = houseRob(arr,i+1,dp);
        dp[i] = Math.max(rob,skip);
        return dp[i];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna