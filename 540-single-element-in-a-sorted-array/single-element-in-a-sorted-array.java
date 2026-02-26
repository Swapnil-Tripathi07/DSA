class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int target = 0;
        if(nums.length==1){
            target = nums[i];
        }
        // if(nums.length == 3){
        //     if(nums[0]!=nums[1]){
        //         target = nums[0];
        //     }
        //     else{
        //         target = nums[2];
        //     }
        // }
        else{
            while(i<nums.length-1){
                if(nums[i] == nums[i+1]){
                    i = i+2;
                    continue;
                }
                else{
                    target = nums[i];
                    break;
                }
            }
        }
        if(i==nums.length-1){
            target = nums[i];
        }
        
        return target;
    }
}