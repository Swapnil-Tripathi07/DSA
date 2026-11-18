class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            adj.add(new ArrayList<Integer>());

            for(int j = 0 ; j<isConnected[i].length ; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                
                }
            }
        }

        int V = adj.size();
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i = 0 ; i<V ; i++){
            if(visited[i] == false){
                count++;
                bfs(i , adj , visited);
            }
        }
        return count;
         
    }


    public void bfs(int u , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();

            for(Integer i : adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna