class Solution {
    public int[] rearrangeArray(int[] arr) {
        int[] arr1 = new int[arr.length/2];
        int[] arr2 = new int[arr.length/2];
        int a = 0;
        int b = 0;
        for(int i = 0  ; i<arr.length ; i++){
            if(arr[i]>=0){
                arr1[a] = arr[i];
                a++;
            }
            else{
                arr2[b] = arr[i];
                b++;
            }
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>=0){
                arr[k] = arr1[i];
                i++;
                k++;
            }
            if(arr2[j]<0){
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }
        return arr;
    }
}