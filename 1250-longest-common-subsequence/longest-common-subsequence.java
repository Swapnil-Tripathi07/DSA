class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] dp = new int[s1.length][s2.length];
        for(int i = 0 ; i<s1.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        return lCSDP(s1,s2,0,0,dp);
    }



    //strarts from 0 index.
    public static int lCS(String s1 , String s2){
        if(s1.length()==0 || s2.length()==0){
            return 0;
        }

        if(s1.charAt(0) == s2.charAt(0)){
            return 1 + lCS(s1.substring(1,s1.length())   ,    s2.substring(1,s2.length()));
        }

        int one = lCS(s1.substring(1,s1.length()) , s2);
        int two = lCS(s1,s2.substring(1,s2.length()));
        return Math.max(one,two);
    }



    //DP Approach
    public static int lCSDP(char[] s1 , char[] s2 , int i , int j , int[][] dp){
        if(i>s1.length-1 || j>s2.length-1){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1[i] == s2[j]){
            return 1 + lCSDP(s1,s2,i+1,j+1,dp);
        }

        int one = lCSDP(s1,s2,i+1,j,dp);
        int two = lCSDP(s1,s2,i,j+1,dp);
        dp[i][j] = Math.max(one,two);
        return dp[i][j];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna