import java.util.*;

class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        
        for (String word : words)
            stack.push(word);
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty())
                sb.append(" ");
        }
        
        return sb.toString();
    }
}
