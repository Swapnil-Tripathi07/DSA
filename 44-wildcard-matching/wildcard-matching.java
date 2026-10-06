class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];

        for(int i = 0 ; i<n ; i++){
            Arrays.fill(dp[i],-1);
        }

        //Recursion
        // return solve(s,p,n-1,m-1);

        //Memoization
        return solve(s,p,n-1,m-1,dp);
    }


    //RECURSION
    public boolean solve(String s, String p, int i, int j) {

    // Both strings processed
        if (i < 0 && j < 0) {
            return true;
        }

    // Pattern finish but string remains
        if (j < 0) {
            return false;
        }

    // String finish
        if (i < 0) {

        //Rest pattern contains *
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }

            return true;
        }

    // Same character or ?
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return solve(s, p, i - 1, j - 1);
        }

    // * wala case hai
        if (p.charAt(j) == '*') {
            return solve(s, p, i, j - 1) || solve(s, p, i - 1, j);
        }

    // Different characters
        return false;
    }



   public boolean solve(String s, String p, int i, int j, int[][] dp) {

    // Both strings processed
        if (i < 0 && j < 0) {
            return true;
        }

    // Pattern finish but string remains
        if (j < 0) {
            return false;
        }

    // String finish
        if (i < 0) {

        // Rest pattern contains *
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }

            return true;
        }

    // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

    // Same character or ?
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            boolean ans = solve(s, p, i - 1, j - 1, dp);

            dp[i][j] = ans ? 1 : 0;
            return ans;
        }

    // * wala case
        if (p.charAt(j) == '*') {

            boolean ans = solve(s, p, i, j - 1, dp)
                       || solve(s, p, i - 1, j, dp);

            dp[i][j] = ans ? 1 : 0;
            return ans;
        }

    // Different characters
        dp[i][j] = 0;
        return false;
    }
}    

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna