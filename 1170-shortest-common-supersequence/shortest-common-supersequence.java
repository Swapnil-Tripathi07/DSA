class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return solve(str1,str2,"");
    }


    public String solve(String s1, String s2, String up) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // LCS DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i)== s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
                }
            }
        }
        return func(s1,s2,dp,up);
    }
     
    public String func(String s1, String s2 , int[][] dp , String up){
        int n = s1.length();
        int m  = s2.length();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {

            // Same character
            if (s1.charAt(i) == s2.charAt(j)) {

                up = up + s1.charAt(i);

                i++;
                j++;
            }

            // Different character
            else {
                if (dp[i + 1][j] >= dp[i][j + 1]) {
                    up += s1.charAt(i);
                    i++ ;
                }
                else {
                    up += s2.charAt(j);
                    j++;
                }
            }
        }

        // Remaining characters of s1
        while (i < n) {
            up = up + s1.charAt(i);
            i++;
        }

        // Remaining characters of s2
        while (j < m) {
            up = up + s2.charAt(j);
            j++;
        }

        return up;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna