class Solution{
    public int triangularSum(int[] arr){
        int n = arr.length;
        while(n!=1){
            int[] ans = new  int[n-1];
            int p = 0;
            for(int i = 0  ; i<n-1 ; i++){
                ans[p] = (arr[i]+arr[i+1])%10;
                p++;
            }
            arr = ans;
            n--;
        }
        return arr[0];
    }
}