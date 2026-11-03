class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        int max = Arrays.stream(nums).max().getAsInt();

        for(int i = 0 ; i<nums.length ; i++){
            while(nums[i] != max){
                nums[i]++;
                count++;
            }
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna