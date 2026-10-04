class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(0,s,dp);
    }

    public static int solve(int i, String s, int[] dp) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int one = solve(i + 1, s, dp);
        int two = 0;

        if (i + 1 < s.length()) {
            String st = s.substring(i, i + 2);
            int n = Integer.parseInt(st);

            if (n <= 26) {
                two = solve(i + 2, s, dp);
            }
        }

        return dp[i] = one + two;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna