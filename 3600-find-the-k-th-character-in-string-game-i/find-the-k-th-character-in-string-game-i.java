class Solution {
    public char kthCharacter(int k) {

        String ans = solve("","a","",k);
        return ans.charAt(k-1);
        
    }

    public static String solve(String gen , String word , String str , int k){
        if(word.length()>=k){
            return word;
        }

        for(int i = 0 ; i<word.length() ; i++){
            char ch = (char)(word.charAt(i) + 1);
            str = str + ch;
        }

        gen = str;
        word = word + gen;


        return solve(gen,word,"",k);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna