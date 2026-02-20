class Solution {
    public boolean isHappy(int num){
        int sum = 0;
        boolean flag = true;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(num,0);
        while(sum>=0){
            while(num>0){
                int temp = num%10;
                sum = sum + (temp*temp);
                num = num/10;

            }
            if(sum == 1){
                flag = true;
                break;
            }
            if(map.containsKey(sum)){
                flag = false;
                break;
            }
            else{
                int i =1;
                map.put(sum,i);
                i++;
            }
            num = sum;
            sum = 0;
        }
        return flag;

    }
}