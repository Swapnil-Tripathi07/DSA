import java.util.*;

class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return findTribonacci(n, dp);
    }

    private int findTribonacci(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = findTribonacci(n - 1, dp) + findTribonacci(n - 2, dp) + findTribonacci(n - 3, dp);

        return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna