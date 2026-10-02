class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0 ; i<s.length() ; i++){
            Arrays.fill(dp[i],-1);
        }
        // return solve(s,t,0,0,dp);
        return tabulation(s,t);
    }

    public int solve(String s , String t , int i , int j , int[][] dp){
        if(j==t.length()){
            return 1;
        }
        if(i>s.length()-1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       
        if(s.charAt(i) == t.charAt(j)){
            int include = solve(s,t,i+1,j+1,dp);
            int exclude = solve(s,t,i+1,j,dp);
            return dp[i][j] = include + exclude;
        }
        return dp[i][j] = solve(s,t,i+1,j,dp);
    }

    public int tabulation(String s , String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i<dp.length ; i++){ //if(j==t.length()) return 1;
            dp[i][m] = 1;
        }
        for(int j = 0 ; j<m ; j++){
            dp[n][j] = 0;
        }
        
        for(int i = n-1 ; i>=0 ; i--){
            for(int j = m-1 ; j>=0 ;j--){
                if(s.charAt(i) == t.charAt(j)){
                    int first = dp[i+1][j+1];
                    int second = dp[i+1][j];
                    dp[i][j] = first+second;
                }
                else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna