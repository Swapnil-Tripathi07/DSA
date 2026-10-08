class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        for(int i = 0 ; i<nums1.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans  = 0;
        int prev = 0;
        int index = -1;

        for(int i = 0 ; i<nums1.length ; i++){
            for(int j = 0  ;j<nums2.length ; j++){
                prev = ans;
                ans = Math.max(ans,solve(nums1,nums2,i,j,dp));
                if(ans>prev){
                    index = i;
                }
            }
        }
        return ans;
    }

    public int solve(int[] nums1 , int[] nums2 , int i , int j , int[][] dp){
        if(i>=nums1.length || j>=nums2.length){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(nums1[i] == nums2[j]){
            return dp[i][j] = 1 + solve(nums1,nums2,i+1,j+1,dp);
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j];
    }


    //To print max length subarray;
    // public static void main(String[] args){
    //     int[] nums1 = {1,2,3,2,1};
    //     int[] nums2 = {3,2,1,4,7};

    //     int[][] dp = new int[nums1.length+1][nums2.length+1];

    //     for(int i = 0 ; i<nums1.length ; i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     int ans  = 0;
    //     int prev = 0;
    //     int index = -1;

    //     for(int i = 0 ; i<nums1.length ; i++){
    //         for(int j = 0  ;j<nums2.length ; j++){
    //             prev = ans;
    //             ans = Math.max(ans,solve(nums1,nums2,i,j,dp));
    //             if(ans>prev){
    //                 index = i;
    //             }
    //         }
    //     }

    //     while(ans>0){
    //         System.out.print(nums1[index++]);
    //         ans--;
    //     }
    // }    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna