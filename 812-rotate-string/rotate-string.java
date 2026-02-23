class Solution {
    public boolean rotateString(String  s, String goal){
        boolean flag = false;
        String s1 = s;
        char[] arr = s1.toCharArray();
        int j = 0;
        if(s.equals(goal)){
            flag = true;
        }
        else{
            while(j<=arr.length){
                for(int i = 0 ;i<arr.length - 1 ; i++){
                    char temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                String s2  = "";
                for(int i = 0 ; i<arr.length ; i++){
                    s2 += arr[i];
                }
                if(s2.equals(goal)){
                    flag = true;
                    break;
                }
                s1 = s2;
                j++;
            }
        }
        return flag;
    }
}