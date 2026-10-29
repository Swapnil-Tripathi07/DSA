class Solution {
    public int minCost(int k, int[] cuts) {
        Arrays.sort(cuts);
        int[] newCut = new int[cuts.length + 2];
        int n = newCut.length;

        newCut[0] = 0;

        for (int i = 1; i <= cuts.length; i++) {
            newCut[i] = cuts[i - 1];
        }

        newCut[n - 1] = k;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(newCut, 0, n - 1, dp);
    }

    public int solve(int[] cuts, int l, int r, int[][] dp) {
        if (r - l == 1) {   //No cuts exists.
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int min = Integer.MAX_VALUE;

        for (int i = l + 1; i < r; i++) {
            int temp = solve(cuts, l, i, dp) + solve(cuts, i, r, dp) + (cuts[r] - cuts[l]);
            min = Math.min(min, temp);
        }

        return dp[l][r] = min;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna