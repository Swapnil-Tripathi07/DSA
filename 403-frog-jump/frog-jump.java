import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {

        // stone position = possible jump size
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // HashSet
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0); // Start point

        for (int stone : stones) {// Check every stone

            // Get all jumps that can reach this stone
            HashSet<Integer> jumps = map.get(stone);

            for (int jump : jumps) {
                for (int nextJump = jump - 1;   // These are three jumps
                     nextJump <= jump + 1;
                     nextJump++) {

                    if (nextJump <= 0) {
                        continue;
                    }

                    int nextStone = stone + nextJump;

                    // Check if the next stone exists
                    if (map.containsKey(nextStone)) {
                        map.get(nextStone).add(nextJump);  // Store jump for next stone
                    }
                }
            }
        }

        // Check the last stone
        HashSet<Integer> lastStone =
                map.get(stones[stones.length - 1]);

        if (lastStone.size() > 0) {
            return true;
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna