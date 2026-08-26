class Solution {

    //Memoization
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(robbing(nums,0,nums.length-2,dp1),robbing(nums,1,nums.length-1,dp2));
    }

    public int robbing(int[] arr , int start , int end,int[] dp){

        if(start>end){
            return 0;
        }

        if(dp[start] != -1) return dp[start];

        int robHouse = arr[start] + robbing(arr,start+2,end,dp);
        int skip = robbing(arr,start+1,end,dp);
        dp[start] = Math.max(robHouse,skip);
        return dp[start];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna