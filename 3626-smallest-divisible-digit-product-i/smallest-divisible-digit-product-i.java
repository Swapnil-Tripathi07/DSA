class Solution {
    public int smallestNumber(int n, int t) {
        int mul = 1;
        int res = 0;
        int num = n;
        if(t==1){
            res = n;
        }
        else{
            while(n>0){
                int temp = n%10;
                mul *= temp;
                n = n/10;
            }
            if(mul%t==0){
                res = num;
            }
            else{
                mul = 1;
                num++;
                n = num;
            
                while(mul%t != 0){
                    while(n>0){
                        int temp = n%10;
                        mul *= temp;
                        n = n/10;
                    }
                    if(mul%t==0){
                        res = num;
                        break;
                    }
                    else{
                        num++;
                        n = num;
                        mul = 1;
                    }
                }
            }
            
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna