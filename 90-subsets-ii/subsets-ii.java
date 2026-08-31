import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // This ensures identical subsets are generated in the exact same order.
        Arrays.sort(nums);

        List<List<Integer>> allSubsets = sub(new ArrayList<>(), nums, 0);

        Set<List<Integer>> set = new HashSet<>(allSubsets);

        return new ArrayList<>(set);
    }

    private List<List<Integer>> sub(List<Integer> p, int[] nums, int index) {
        if (index == nums.length) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int val = nums[index];

        List<Integer> includeP = new ArrayList<>(p);
        includeP.add(val);

        List<List<Integer>> left = sub(includeP, nums, index + 1);
        List<List<Integer>> right = sub(p, nums, index + 1);

        left.addAll(right);
        return left;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna