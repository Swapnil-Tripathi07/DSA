class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return new int[0];
        
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        
        // Fill left_max
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                left_max[i] = arr[i]; // Start of a block
            } else {
                left_max[i] = Math.max(left_max[i - 1], arr[i]);
            }
        }
        
        // Fill right_max
        right_max[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if ((i + 1) % k == 0) {
                right_max[i] = arr[i]; // End of a block
            } else {
                right_max[i] = Math.max(right_max[i + 1], arr[i]);
            }
        }
        
        int[] result = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            // Maximum for window [i, i+k-1]
            result[i] = Math.max(right_max[i], left_max[i + k - 1]);
        }
        
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna