class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;
        int n = arr.length;
        for(int i = 0 ; i<arr.length; i++){
            totalSum += (arr[i] * (i+1) * (n-i));

        }
        int totalEven = 0;
        for(int i = 0 ;i<arr.length ; i++){
            totalEven += arr[i] * (((i+1) * (n-i)) / 2);
        
        }
        return totalSum-totalEven;
    }
}