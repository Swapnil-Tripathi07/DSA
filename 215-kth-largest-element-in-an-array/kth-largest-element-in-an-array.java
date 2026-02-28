class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int target = nums[nums.length-k];
        return target;
    }
}