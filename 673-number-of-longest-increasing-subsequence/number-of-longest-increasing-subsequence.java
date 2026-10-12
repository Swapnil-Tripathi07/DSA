class Solution {
    public int findNumberOfLIS(int[] nums) {
        return solve1(nums);
    }

    public int solve1(int[] nums) {
        int n = nums.length;

        int[] t = new int[n];   //stores LIS ending at index i.
        int[] count = new int[n];   //stores count of LIS ending at index i.
        Arrays.fill(t,1);
        Arrays.fill(count,1);
    
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    if(t[j]+1 == t[i]){
                        count[i] += count[j];
                    }
                    else if(t[j]+1 > t[i]){
                        t[i] = t[j]+1;
                        count[i] = count[j];
                    }
                }
            }
        }

        int maxVal = Arrays.stream(t).max().getAsInt();
        int result = 0;
        for(int i= 0  ; i<n ; i++){
            if(t[i] == maxVal){
                result += count[i];
            }
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna