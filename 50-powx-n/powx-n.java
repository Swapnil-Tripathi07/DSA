class Solution {
    public double myPow(double x, int n) {
        long N = n;
        boolean negative = N < 0;
        if (negative) N = -N;

        double result = 1.0;
        double current = x;

        while (N > 0) {
            if ((N & 1) == 1) {
                result *= current;
            }
            current *= current;
            N >>= 1;
        }

        return negative ? 1.0 / result : result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna