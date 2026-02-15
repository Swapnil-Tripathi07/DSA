class Solution {
    public void binSort(int[] arr) {
        int count = 0;
        for(int i  = 0 ; i<arr.length ; i++){
            if(arr[i] == 1){
                count++;
            }
        }
        for(int i=0 ; i<(arr.length-count) ; i++){
            arr[i] = 0;
        }
        for(int i = (arr.length-count) ; i<arr.length ; i++){
            arr[i] = 1;
        }
        
    }
}
