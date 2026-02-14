class Solution {
    public boolean arrayStringsAreEqual(String[] word1 , String[] word2){
        String flag1 = "";
        String flag2 = "";
        for(int i = 0 ; i<word1.length ; i++){
            flag1 = flag1+word1[i];
        }
        for(int i = 0 ; i<word2.length ; i++){
            flag2 = flag2+word2[i];
        }
        if(flag1.equals(flag2)){
            return true;
        }
        return false;
    }
}
