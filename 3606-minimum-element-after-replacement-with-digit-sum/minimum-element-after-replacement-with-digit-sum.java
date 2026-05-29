class Solution {
    public int minElement(int[] nums) {
        int sum = 0;
    
        int n = nums.length-1;
        for(int i = 0; i<=n ; i++){
            while(nums[i]>0){
                sum = sum + (nums[i]%10);
                nums[i] = nums[i]/10;
            }
            nums[i] = sum;
            sum = 0;
        }
        int min = nums[0];
        for(int i = 0 ; i<=n ; i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna