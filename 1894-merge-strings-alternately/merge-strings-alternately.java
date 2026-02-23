class Solution {
    public String mergeAlternately(String str1, String str2){
        String merged = "";
        int i = 0;
        int j = 0;
        while(i<str1.length() && j<str2.length()){
            merged = merged+ str1.charAt(i)+str2.charAt(i);
            i++;
            j++;
        }
        while(i<str1.length()){
            merged += str1.charAt(i);
            i++;
        }
        while(j<str2.length()){
            merged += str2.charAt(j);
            j++;
        }
        return merged;
    }
}