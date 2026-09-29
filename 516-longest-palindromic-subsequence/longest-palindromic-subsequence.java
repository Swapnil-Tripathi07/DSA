class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = "";
        for(int i = s.length()-1 ; i>=0 ; i--){
            s2 = s2+s.charAt(i);
        }

        //s1 ka reverse karke original s1 ke sath LCS find kar diya, to palindromic hi subsequence hi milega.

        int[][] dp =  new int[s.length()][s2.length()];
        for(int i = 0 ; i<s.length() ;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,s2,0,0,dp);

    }

    public int solve(String s1 , String s2 , int i , int j , int[][] dp){
        if(i>s1.length()-1 || j>s2.length()-1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(s1,s2,i+1,j+1,dp);
        }
        int one = solve(s1,s2,i+1,j,dp);
        int two = solve(s1,s2,i,j+1,dp);
        return dp[i][j] = Math.max(one,two);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna