class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        return common(nums1,nums2,0,0);
    }

    public int common(int[] nums1 , int[] nums2 , int i , int j){
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                return nums1[i];
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna