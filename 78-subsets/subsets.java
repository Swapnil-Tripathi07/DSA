class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return sub(new ArrayList<>(), nums, 0);
    }

    public List<List<Integer>> sub(List<Integer> p, int[] up, int index) {
        if (index == up.length) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int val = up[index]; //ch = up.charAt(0)

        // Equivalent to p + ch (create a new list because Java lists are mutable)
        List<Integer> take = new ArrayList<>(p);
        take.add(val);

        List<List<Integer>> left = sub(take, up, index + 1); // take it
        List<List<Integer>> right = sub(p, up, index + 1);   // ignore it (pass original p)
        
        left.addAll(right);
        return left;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna