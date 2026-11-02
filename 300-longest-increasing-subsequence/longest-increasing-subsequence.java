class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        return solve(nums,ans);
    }

    public static int solve(int[] nums, ArrayList<Integer> ans){
        for(int i = 1 ; i<nums.length ; i++){
            if(nums[i]>ans.getLast()){
                ans.add(nums[i]);
            }
            else if(nums[i]<ans.getLast()){
                int index = binarySearch(ans,nums[i]);
                ans.set(index,nums[i]);
            }
        }
        return ans.size();

    }

    public static int binarySearch(ArrayList<Integer> list , int target){
        int start = 0;
        int end = list.size()-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(target<list.get(mid)){
                end = mid-1;
            }
            else if(target>list.get(mid)){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return start;   // ye isliye kara hai kyokin agar element nahi mila to ye uski correct index
        // return karega ki yahan pe ye element insert hona chahiye.
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna