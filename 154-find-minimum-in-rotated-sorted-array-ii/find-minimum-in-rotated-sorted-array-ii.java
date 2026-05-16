class Solution {
    static int findMin(int[] arr){
        int start = 0;
        int end = arr.length -1;
        int res = 0;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]<arr[end]){
                end = mid;
            }else if(arr[mid]>arr[end]){
                start = mid+1;
            }
            else{
                end--;
            }
            res = arr[mid];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna