class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            // move while consecutive
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            // check if range or single
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(start + "");
            }
        }

        return result;
    }
}