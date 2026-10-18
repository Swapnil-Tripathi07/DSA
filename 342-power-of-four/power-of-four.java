class Solution {
    public boolean isPowerOfFour(int n) {
        boolean flag = false;
        while(n>0){
            if(n==1){
                flag = true;
                break;
            }
            if(n%4 == 0){
                n = n/4;
            }
            else{
                flag = false;
                break;
            }
           
        }
        return flag;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna