class Solution {
    public int kthSmallest(int[][] matrix , int k){
        int[] arr = new int[matrix.length*matrix.length];
        int kth = 0;
        for(int i = 0; i<matrix.length ; i++){
            for(int j = 0; j<matrix[i].length ; j++){
                arr[kth++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);

        return arr[k-1];
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna