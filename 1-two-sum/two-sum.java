class Solution {
    public int[] twoSum(int[] nums, int target) {
        return twosum(nums,target);
    }

    public static int[] twosum(int[] arr , int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i<arr.length ; i++){
            int sum = target-arr[i];
            if(map.containsKey(sum)){
                return new int[]{map.get(sum),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna