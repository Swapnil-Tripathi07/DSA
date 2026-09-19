// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum=0;
//         for(int i=0; i<nums.length; i++){
//             sum = sum + nums[i];
//         }
//         if(sum%2!=0) return false;
//         int target = sum/2;
//         return calculate(nums, 0 , target);
//     }
//     public static boolean calculate(int[]nums, int i, int target){
//         if(target==0) return true;
//         if(i==nums.length) return false;
//         boolean take = false;
//         if(nums[i]<=target){
//              take = calculate(nums, i+1, target-nums[i]);
//         }
//         boolean notTake = calculate(nums, i+1, target);
//         return take || notTake;
//     }
// }



//MEMOIZATION
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
        }
        if(sum%2!=0) return false;
        int target = sum/2;
         //index i and target both are changing 
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return calculate(nums, 0 , target,dp);
    }
    public static boolean calculate(int[]nums, int i, int target,Boolean[][] dp){
        if(target==0) return true;
        if(i==nums.length) return false;

        if (dp[i][target] != null) return dp[i][target];


        boolean take = false;
        if(nums[i]<=target){
             take = calculate(nums, i+1, target-nums[i],dp);
        }
        boolean notTake = calculate(nums, i+1, target,dp);
        return  dp[i][target]= take || notTake;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna