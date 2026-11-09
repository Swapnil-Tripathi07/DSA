class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for (String s : operations) {
            if (s.contains("+")) {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna