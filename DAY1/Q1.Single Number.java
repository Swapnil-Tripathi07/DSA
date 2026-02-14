class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int num = nums[0];
        
        // Loop starting from the second element
        for (int i = 1; i < n; i++) {
            num ^= nums[i]; // XOR operation
        }
        
        return num;
    }
}
