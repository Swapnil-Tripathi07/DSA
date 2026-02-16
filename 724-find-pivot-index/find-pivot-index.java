class Solution {
    public int pivotIndex(int[] arr){
        int totalSum = 0;
        for(int sum:arr){
            totalSum+=sum;
        }

        int leftSum = 0;
        for(int i = 0 ;i<arr.length ; i++){
            int rightSum = totalSum - leftSum - arr[i];
            if(leftSum ==  rightSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}