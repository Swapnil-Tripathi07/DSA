class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums,target,0,0);
    }

    public static int ways(int[] nums , int target , int sum , int i){
        if(i>nums.length-1){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        int plus = ways(nums,target,sum+nums[i],i+1);
        int minus =ways(nums,target,sum-nums[i],i+1);
        return plus+minus;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna