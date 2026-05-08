import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int duplicate = -1, missing = 1; 

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                duplicate = nums[i]; 
            } else if (nums[i + 1] > nums[i] + 1) {
                missing = nums[i] + 1;
            }
        }
        if (nums[nums.length - 1] != nums.length) {
            missing = nums.length;
        }

        return new int[]{duplicate, missing};
    }
}