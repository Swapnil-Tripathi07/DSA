class Solution {
    static int findMin(int[] arr){
        int start = 0;
        int end = arr.length -1;
        int res = 0;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]<arr[end]){
                end = mid;
            }else{
                start = mid+1;
            }
            res = arr[mid];
        }
        return res;
    }
}