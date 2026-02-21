class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int temp = 1;
        int miss =0;
        for(int i = 0 ; i<nums.length; i++){
            if(nums[i] == temp){
                temp++;
            }
            else{
                if(temp<nums[i])
                miss = temp;
                continue;
            }
        }
        return temp;
    }
}
