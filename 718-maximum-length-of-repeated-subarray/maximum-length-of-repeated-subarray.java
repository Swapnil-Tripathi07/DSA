import java.util.*;

class Solution {

    public int findLength(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                ans = Math.max(ans, solve(nums1, nums2, i, j, dp));
            }
        }

        return ans;
    }

    public int solve(int[] nums1, int[] nums2,int i, int j, int[][] dp) {

        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {

            dp[i][j] = 1 + solve(nums1, nums2,i + 1, j + 1, dp);

        } else {

            dp[i][j] = 0;
        }

        return dp[i][j];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna