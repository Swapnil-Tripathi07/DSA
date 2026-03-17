class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int sum = 0;
        for(int i = 0 ; i<n ; i++){
              if(i==n-1){
                return (sum+=duration);
               }
            int start = timeSeries[i];
            int end = timeSeries[i+1];
            int gap = end-start;
           
              if( gap > duration)
                sum+=duration;
             else
                sum+=gap;
            
        }
        return sum;
    }
}