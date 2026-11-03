class Solution {

    public static Boolean isPalindrome(String s, int i, int j,Boolean dp2[][]) {

        if (i >= j) return true;
        if(dp2[i][j]!=null) return dp2[i][j];
        if (s.charAt(i) != s.charAt(j)) {
            return dp2[i][j]=false;
        }

        return dp2[i][j]=isPalindrome(s, i + 1, j - 1,dp2);
    }

    public static int cut(String s, int i, int j,Boolean dp2[][] , int dp[][]) {

        if (i >= j) return 0;
        
        if (isPalindrome(s, i, j,dp2)) return 0;
        if (dp[i][j] != -1) return dp[i][j];


        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            if (isPalindrome(s, i, k,dp2)) {

                int c = 1 + cut(s, k + 1, j,dp2,dp);

                min = Math.min(min, c);
            }
        }

        return dp[i][j]=min;
    }

    public int minCut(String s) {
        int dp [][] = new int [s.length()][s.length()];
        Boolean dp2[][] = new Boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            Arrays.fill(dp[i], -1);

        }
        return cut(s, 0, s.length() - 1,dp2,dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna