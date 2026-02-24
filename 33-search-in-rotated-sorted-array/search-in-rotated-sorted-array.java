class Solution {
    int search(int[] nums , int target){
        int start = 0;
        int res = -1;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                res = mid;
                break;
            }
            else if(nums[start]<=nums[mid]){
                if(nums[start]<=target &&nums[mid]>=target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(nums[start]>target && nums[mid]<=target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return res;
    }
}