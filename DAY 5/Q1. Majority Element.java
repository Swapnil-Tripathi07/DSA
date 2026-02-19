class Solution {
    public int majorityElement(int[] nums){
        Arrays.sort(nums);
        int count = 1;
        int res = 0;
        if(nums.length == 1){
            return nums[0];
        }
        for(int i = 0 ; i<=nums.length-2 ; i++){
            if(nums[i]==nums[i+1]){
                count++;
            }
            if(count>nums.length/2){
                res = nums[i];
                break;
            }
            else if(nums[i] != nums[i+1]){
                count = 1;
            }

        }
        return res;
    }
}
