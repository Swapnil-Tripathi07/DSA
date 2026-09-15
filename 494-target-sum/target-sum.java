class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i : nums){
            totalSum += i;
        }
        //TotalSum ko 2 se multiply isliye kiya kyokin, sum ki range let suppose -5 se 5 tak change
        //ho rahi hai. 
        int[][] dp = new int[totalSum*2 + 1][nums.length];
        for(int i = 0 ;i<=totalSum*2 ; i++){
            Arrays.fill(dp[i],-1);
        }

        // return ways(nums,target,0,0,dp,totalSum);
        return waysTabulation(nums,target);
    }


    //Recursion
    // public static int ways(int[] nums , int target , int sum , int i,int[] dp){
    //     if(i>nums.length-1){
    //         if(sum == target){
    //             return dp[i];
    //         }
    //         return 0;
    //     }

    //     if(dp[i] != -1) return dp[i];

    //     int plus = ways(nums,target,sum+nums[i],i+1,dp);
    //     int minus =ways(nums,target,sum-nums[i],i+1,dp);
    //     return dp[i] = plus+minus;
    // }



    //MEMOIZATION
    // public static int ways(int[] nums , int target , int sum , int i , int[][] dp,int sumArr){
    //     if(i>nums.length-1){
    //         if(sum == target){
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     //sum -ve me bhi ja raha hai aur -ve indexing hoti nahi hai, isliye sum+totalValue add kardi.
    //     //jisse indexing +ve me rahe.
    //     if(dp[sum+sumArr][i] != -1){
    //         return dp[sum+sumArr][i];
    //     }

    //     int plus = ways(nums,target,sum+nums[i],i+1,dp,sumArr);
    //     int minus =ways(nums,target,sum-nums[i],i+1,dp,sumArr);
    //     return dp[sum+sumArr][i] = plus+minus;
    // }




    //TABULATION
    public static int waysTabulation(int[] nums, int target) {

        int n = nums.length;

        int sumArr = 0;

        for (int x : nums) {
            sumArr += x;
        }

        // Target ko achieve nahi kar paye
        if (target > sumArr || target < -sumArr) {
            return 0;
        }

        int[][] dp = new int[2 * sumArr + 1][n + 1];

        // ye recursion ki base condition ko iteration me write kar diya
        //kyokin tabulation me pehle base case fill karte hain.
        for (int sum = -sumArr; sum <= sumArr; sum++) {

            if (sum == target) {
                dp[sum + sumArr][n] = 1;
            } else {
                dp[sum + sumArr][n] = 0;
            }
        }

        // right se left fill kar rahe hain table.
        for (int i = n - 1; i >= 0; i--) {

            for (int sum = -sumArr; sum <= sumArr; sum++) {

                int plus = 0;
                int minus = 0;

                if(sum+nums[i]<=sumArr){
                    plus = dp[sum+nums[i]+sumArr][i+1];
                }
                if(sum-nums[i]>=-sumArr){
                    minus = dp[sum-nums[i]+sumArr][i+1];
                }

                dp[sum + sumArr][i] = plus+minus;
            }
        }

        return dp[sumArr][0];
    }    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna