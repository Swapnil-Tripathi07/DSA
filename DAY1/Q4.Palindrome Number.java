class Solution {
    public boolean isPalindrome(int n){
        int flag = 0;
        if(n<0){
            return false;
        }
        else{
            for(int i = n ; i>0 ; i=i/10 ){
                flag = flag*10 + (i%10);
            }
            if(flag == n){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
