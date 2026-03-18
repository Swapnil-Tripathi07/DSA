class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;


        for(int i = 0 ; i<arr.length ; i++){
            int sum = 0;
            int len =1;
            for(int j= i ; j<arr.length ; j++){
                sum += arr[j];
                if(len%2 != 0){
                    totalSum+=sum;
                }
                len++;
            }
        }
        return totalSum;
    }
}