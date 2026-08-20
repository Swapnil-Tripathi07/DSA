class Solution {
    public boolean isSubsequence(String s, String t) {
        int i  = 0;
        int j = 0;
        return subsequence(s,t,i,j);
    }

    public boolean subsequence(String s , String t,int i , int j){
        if(i == s.length()){
            return true;
        }
        if(i>s.length()-1 || j>t.length()-1){
            return false;
        }
        

        if(s.charAt(i) == t.charAt(j)){
            i++;
            j++;
            return subsequence(s,t,i,j);
        }
        else{
            j++;
            return subsequence(s,t,i,j);
        }
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna