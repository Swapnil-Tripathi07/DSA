class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][][] dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];

        //recursion
        // return solve(s1, s2, s3, 0, 0, 0);


        //DP Approach
        return dpApproach(s1,s2,s3,0,0,0,dp);
    }


    //Recursion
    public boolean solve(String s1, String s2, String s3,int i, int j, int k) {
        if (k == s3.length()) {
            return true;
        }
        boolean first = false;
        boolean second = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            first = solve(s1, s2, s3, i + 1, j, k + 1);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            second = solve(s1, s2, s3, i, j + 1, k + 1);
        }
        return first || second;
    }




    public boolean dpApproach(String s1, String s2, String s3,int i, int j, int k , Boolean[][][] dp) {
        if (k == s3.length()) {
            return true;
        }

        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }

        boolean first = false;
        boolean second = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            first = dpApproach(s1, s2, s3, i + 1, j, k + 1,dp);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            second = dpApproach(s1, s2, s3, i, j + 1, k + 1,dp);
        }
        return dp[i][j][k] = first || second;
    }


}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna