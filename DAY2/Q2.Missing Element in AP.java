class Solution {
    public int findMissing(int[] arr){
        if(arr.length == 2){
            return arr[1]+(arr[1]-arr[0]);
        }
        int d1= arr[1]-arr[0];
        int d2= arr[2]-arr[1];
        int d3= arr[arr.length-1]-arr[arr.length-2];
        int flag = 0;
        int diff =0;
        int count = 0;
        if(d1==d2 || d2 == d3){
            diff = d2;
        }
        else{
            diff = d1;
        }
        for(int i = 0 ; i<=arr.length -2 ; i++){
            count++;
            if(arr[i+1]-arr[i] != diff){
                flag = arr[i]+diff;
                return flag;
            }
        }
        if(count == (arr.length-1)){
            return arr[arr.length-1]+diff;
        }
        else{
            return flag;
        }
    }
}
