class Solution {
    public long countCommas(long n) {
        long ans = 0;
        for(long i = 1000 ; i<=n ;i*=1000){
            ans = ans + n-i + 1;
            if(i>n/1000) break;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna