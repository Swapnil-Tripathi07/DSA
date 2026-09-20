class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        return solve(strs,0,m,n,dp);
    }

    public int solve(String[] str , int i , int m , int n,int[][][] dp){
        if(i>str.length-1){
            return 0;
        }

        if(dp[i][m][n] != 0){
            return dp[i][m][n];
        }

        int one = 0;
        int zero = 0;
        String s = str[i];
        for(int j = 0 ; j<s.length() ; j++){
            if(s.charAt(j) == '0'){
                zero++;
            }
            else{
                one++;
            }
        }
        int take = 0;
        int skip = 0;

        if (zero <= m && one <= n) {
            // Add 1 to count this string, subtract capacities
            take = 1 + solve(str, i + 1, m - zero, n - one,dp);
        }
        skip = solve(str,i+1,m,n,dp);

        return dp[i][m][n] = Math.max(take,skip);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna