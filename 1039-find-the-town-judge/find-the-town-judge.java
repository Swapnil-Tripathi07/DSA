class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int[] t : trust){
            int u = t[0];
            int v = t[1];

            outdegree[u]++; //u trusts someone
            indegree[v]++;  //v is trusted by someone
        }

        for(int i = 0 ; i<=n ; i++){
            if(indegree[i] == n-1 && outdegree[i]==0){
                return i;
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna