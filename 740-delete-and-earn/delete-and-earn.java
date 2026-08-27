class Solution {

    // Memoization (Same as House Robber)
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freq = new int[max+1];
        for(int element : nums){
            freq[element]++;
        }
        int[] dp = new int[freq.length];
        Arrays.fill(dp,-1);
        return maxProfit(freq,0,dp);
    }

    public static int maxProfit(int[] arr, int i, int[] dp) {

        if (i >= arr.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int delete = i * arr[i] + maxProfit(arr, i + 2, dp);
        int skip = maxProfit(arr, i + 1, dp);
        dp[i] = Math.max(delete, skip);

        return dp[i];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna