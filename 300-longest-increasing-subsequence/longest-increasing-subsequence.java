class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n+1];//n+1 isliye kyokin p=-1 index pe hai ye ek extra value hai.
        for(int[] array : dp){
            Arrays.fill(array,-1);
        }



        //RECURSION
        // return solve(arr,0,-1);

        //Memoization
        return solve(arr,0,-1,dp);
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

        if(dp[i][p+1] != -1){
            return dp[i][p+1];
        }

        int take = 0;
        if(p == -1 || arr[i]>arr[p]){
            take = 1 + solve(arr,i+1,i,dp);
        }
        
        int skip = solve(arr,i+1,p,dp);

        return dp[i][p+1] = Math.max(take,skip);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna