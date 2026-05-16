class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] isNotPrime = new boolean[n];
        int act = 0;

        for (int i = 2; i * i < n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                act++;
            }
        }

        return act;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna