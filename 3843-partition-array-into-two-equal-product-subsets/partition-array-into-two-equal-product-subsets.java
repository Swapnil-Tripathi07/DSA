class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;

        for (int i = 1; i < (1 << n) - 1; i++) {
            long p1 = 1;
            long p2 = 1;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    p1 *= nums[j];
                } else {
                    p2 *= nums[j];
                }
            }

            if (p1 == target && p2 == target) {
                return true;
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna