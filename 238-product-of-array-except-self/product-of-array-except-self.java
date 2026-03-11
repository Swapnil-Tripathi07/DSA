class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalMul = 1;
        int count = 0;
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i] == 0){
                count++;
                continue;
            }
            else{
                totalMul *= nums[i];
            }
        }
        for(int i = 0 ; i<nums.length ; i++){
            if(count>=2){
                nums[i] = 0;
            }
            else if(count==1){
                if(nums[i]==0){
                    nums[i] = totalMul;
                }
                else{
                    nums[i] = 0;
                }
            }
            else{
                nums[i] = totalMul/nums[i];
            }
            
            
        }
        return nums;
    }
}