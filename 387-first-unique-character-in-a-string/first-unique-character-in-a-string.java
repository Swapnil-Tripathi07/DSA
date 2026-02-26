class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i<s.length() ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int index = -1;
        for(int i = 0 ; i<s.length() ; i++){
            int count = map.getOrDefault(s.charAt(i),-1);
            if(count==1){
                index = i;
                break;
            }
        }
        return index;

        
    }
}