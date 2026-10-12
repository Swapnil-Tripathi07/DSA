class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n+1];//n+1 isliye kyokin p=-1 index pe hai ye ek extra value hai.
        for(int[] array : dp){
            Arrays.fill(array,-1);
        }



        //RECURSION
        // return solve(arr,0,-1);

        //MEMOIZATION
        // return solve(arr,0,-1,dp);

        //TABULATION
        // return solve(arr);

        //Single dp array
        return solve1(arr);
    }

    //RECURSION
    public int solve(int[] arr , int i , int p){//i=0 and p=-1
        if(i>=arr.length){
            return 0;
        }

        int take = 0;
        if(p == -1 || arr[i]>arr[p]){
            take = 1 + solve(arr,i+1,i);
        }
        
        int skip = solve(arr,i+1,p);

        return Math.max(take,skip);
    }


    //Memoization
    public int solve(int[] arr , int i , int p , int[][] dp){//i=0 and p=-1
        if(i>=arr.length){
            return 0;
        }

        if(dp[i][p+1] != -1){//p = -1 ho sakta hai to isse positive karne ke liye +1 kiya hai.
            return dp[i][p+1];
        }

        int take = 0;
        if(p == -1 || arr[i]>arr[p]){
            take = 1 + solve(arr,i+1,i,dp);
        }
        
        int skip = solve(arr,i+1,p,dp);

        return dp[i][p+1] = Math.max(take,skip);
    }


    //Tabulation
    public int solve(int[] arr) {

        int n = arr.length;

        int[][] dp = new int[n + 1][n + 1];

    // i goes from n-1 to 0
        for (int i = n - 1; i >= 0; i--) {

        // p can be -1, 0, 1, ..., n-1
        // p+1 => 0, 1, 2, ..., n
            for (int p = i - 1; p >= -1; p--) {

                int take = 0;

                if (p == -1 || arr[i] > arr[p]) {
                    take = 1 + dp[i + 1][i + 1];
                }

                int skip = dp[i + 1][p + 1];

                dp[i][p + 1] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }

    public int solve1(int[] nums) {
        int n = nums.length;

        int[] t = new int[n];
        Arrays.fill(t,1);
    
        int maxLIS = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && t[j]+1>t[i]) {
                    t[i] = t[j]+1;
                    maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }

        return maxLIS;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna