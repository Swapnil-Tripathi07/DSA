class Solution {
    public int[] rowAndMaximumOnes(int[][] arr) {
        int r = 0;
        int o = 0;
        int row = 0;
        int one = 0;
        for(int i = 0; i<arr.length ; i++){
            for(int j = 0 ; j<arr[i].length ; j++){
                if(arr[i][j]==1){
                    r=i;
                    o++;
                }
                if(o>one){
                    row = r;
                    one = o;
                }
                if(j==arr[i].length-1){
                    r=0;
                    o=0;
                }
            }
        }
        return new int[]{row,one};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna