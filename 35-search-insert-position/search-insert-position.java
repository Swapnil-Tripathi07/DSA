class Solution {
    static int searchInsert(int[] arr , int target){
        int start = 0;
        int end = arr.length -1;
        boolean found = false;
        int index = 0;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                index = mid;
                found = true;
                break;
            }
            else if(target<arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid +1;
            }
            if(!found){
                if(target<arr[mid]){
                    index = mid;
                }
                else{
                    index = mid+1;
                }
            }
        }

        return index;
    }
}