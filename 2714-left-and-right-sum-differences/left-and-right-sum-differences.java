class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];
        int[] ansArray = new int[nums.length];
        int leftSum = 0;
        int rightSum = 0;
        for(int i= 1 ; i<nums.length ; i++){
            leftSum += nums[i-1];
            leftArray[i] = leftSum;
        }
        for(int i =nums.length-2 ; i>=0 ; i--){
            rightSum += nums[i+1];
            rightArray[i] = rightSum;
        }
        for(int i = 0 ; i<nums.length ;i++){
            int ans = leftArray[i]-rightArray[i];
            if(ans <0){
                ansArray[i] = -1*ans;
            }
            else{
                ansArray[i] = ans;
            }
             
        }
        return ansArray;

    }
}