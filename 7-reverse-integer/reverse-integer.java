class Solution {
    public int reverse(int n){
        int res = 0;
        if(n<0){
            while(n!=0){
                int temp = n%10;
                n = n/10;
                if(res<Integer.MIN_VALUE/10){
                    return 0;
                }    
                res = (res*10)+temp;
            }
        }
        else if(n>0){
            while(n!=0){
                int temp = n%10;
                n = n/10;
            
                if(res>Integer.MAX_VALUE/10){
                    return 0;
                }
                res = ((res*10)+temp);
            }    
        }
       
       return res;
    }
}