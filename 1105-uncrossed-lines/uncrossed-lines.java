class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i = 0 ; i<nums1.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums1,nums2,0,0,dp);
    }

    public int solve(int[] nums1 , int[] nums2 , int i , int j , int[][] dp){
        if(i>nums1.length-1 || j>nums2.length-1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(nums1[i] == nums2[j]){
            return dp[i][j] = 1 + solve(nums1,nums2,i+1,j+1,dp);
        }
        
        int one = solve(nums1,nums2,i+1,j,dp);
        int two = solve(nums1,nums2,i,j+1,dp);
        return dp[i][j] = Math.max(one,two);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna