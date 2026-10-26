import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        String ans = "";

        for (char ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                ans += ch;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna