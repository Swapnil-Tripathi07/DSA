class Solution {
    public int longestConsecutive(int[] arr){
        Set<Integer> treeSet = new TreeSet<>();
        int count = 1;
        int temp = 1;
        for(int i : arr){
            treeSet.add(i);
        }
        int[] ans = treeSet.stream().mapToInt(x->x).toArray();
        if(ans.length==0){
            temp = 0;
        }
        else{
            for(int i = 0 ; i<ans.length-1 ; i++){
                if(ans[i+1]-ans[i]==1){
                    count++;
                }
                else{
                    if(count>temp){
                        temp = count;
                    }
                    count = 1;
                }
                if(count>temp){
                    temp = count;
                }
                
            }
        }
        
        return temp;
    }
}