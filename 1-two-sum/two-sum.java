class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i= 0 ; i<nums.length ; i++){
            int find = target-nums[i];
            if(map.containsKey(find)){
                return new int[]{i,map.get(find)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna