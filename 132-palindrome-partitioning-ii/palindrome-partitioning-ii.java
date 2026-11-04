// class Solution {

//     public int minCut(String s) {
//         int dp [][] = new int [s.length()][s.length()];
//         Boolean dp2[][] = new Boolean[s.length()][s.length()];
//         for(int i=0; i<s.length(); i++){
//             Arrays.fill(dp[i], -1);

//         }
//         return cut(s, 0, s.length() - 1,dp2,dp);
//     }


//     public static int cut(String s, int i, int j,Boolean dp2[][] , int dp[][]) {

//         if (i >= j){
//             return 0;
//         }

//         if (isPalindrome(s, i, j,dp2)){
//             return 0;
//         }    

//         if (dp[i][j] != -1){
//             return dp[i][j];
//         }


//         int min = Integer.MAX_VALUE;

//         for (int k = i; k < j; k++) {

//             if (isPalindrome(s, i, k,dp2)) {

//                 int c = 1 + cut(s, k + 1, j,dp2,dp);

//                 min = Math.min(min, c);
//             }
//         }

//         return dp[i][j]=min;
//     }

//     public static Boolean isPalindrome(String s, int i, int j,Boolean dp2[][]){

//         if (i >= j){
//             return true;
//         }
//         if(dp2[i][j]!=null){
//             return dp[i][j];
//         }
//         if (s.charAt(i1)21 != s.charAt(j)) {
//             return dp2[i][j]=false;
//         }

//         return dp2[i][j] = isPalindrome(s, i + 1, j - 1,dp2);
//     }
// }













class Solution {

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return solve(s, 0, n,dp) - 1;
    }
    // Recursive function
    public int solve(String s, int i, int n,int[] dp) {

        // Base case
        if (i == n) {
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }

        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + solve(s, j + 1, n,dp);
                min = Math.min(min, cost);
                dp[i] = min;
            }
        }
        return dp[i];
    }
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna