class Solution {
    public boolean isCovered(int[][] arr, int left, int right) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = left ; i<=right ; i++){
            set.add(i);
        }
        boolean flag = false;
        int count = right-left+1;
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = arr[i][0] ; j<=arr[i][1]; j++){
                if(set.contains(j)){
                    count--;
                    set.remove(j);
                }
                if(count==0){
                    flag = true;
                }
            }
        }
        return flag;
    }
}