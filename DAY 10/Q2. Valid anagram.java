class Solution {
    public boolean isAnagram(String s , String t){
        boolean flag = false;
        char[] arr = s.toCharArray();
        char[] arr1 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr);
        String str = new String(arr);
        String str1 = new String(arr1);
        if(str.equals(str1)){
            flag = true;
        }
        return flag;
    }
}
