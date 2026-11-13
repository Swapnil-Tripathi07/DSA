class Solution {
    public String reversePrefix(String s, int k) {
        return reverse(s,0,k-1);
    }

    public static String reverse(String s , int i , int j) {

        char[] arr = s.toCharArray();

        while (i < j) {

            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna