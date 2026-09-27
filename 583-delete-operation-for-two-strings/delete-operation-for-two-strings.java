class Solution {
    public int minDistance(String str1, String str2) {
        if(str1.equals(str2)){
            return 0;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] dp = new int[s1.length][s2.length];
        for(int i = 0 ; i<s1.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = solve(s1,s2,0,0,dp);
        if(ans==0){
            return (s1.length)+(s2.length);
        }
        else{
            return (s1.length-ans)+(s2.length-ans);
        }
    }


    public static int solve(char[] s1 , char[] s2 , int i , int j , int[][] dp){
        if(i>s1.length-1 || j>s2.length-1){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1[i] == s2[j]){
            return 1 + solve(s1,s2,i+1,j+1,dp);
        }

        int one = solve(s1,s2,i+1,j,dp);
        int two = solve(s1,s2,i,j+1,dp);
        dp[i][j] = Math.max(one,two);
        return dp[i][j];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna