class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0; int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int right = 0;
        for(; right<arr.length ; right++){
            int index = map.getOrDefault(arr[right],-1);//Storing old index
            if(index != -1 && index>=left){
                res = Math.max(res , right-1-left+1);
                left = index+1;
            }
            map.put(arr[right],right);
        }
        res = Math.max(res , right-1-left+1);
        return res;
    }
}