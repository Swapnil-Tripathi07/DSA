class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int posIndex = 0;   // even index (0,2,4...)
        int negIndex = 1;   // odd index (1,3,5...)
        
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                result[posIndex] = nums[i];
                posIndex += 2;
            } else {
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        
        return result;
    }
}