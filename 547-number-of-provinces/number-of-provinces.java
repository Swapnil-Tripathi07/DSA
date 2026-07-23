class Solution {
    public int findCircleNum(int[][] matrix) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            adj.add(new ArrayList<>()); // create list for vertex i

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
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
                dfs(i , adj , visited);
            }
        }
        return count;
    }

    static void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for(Integer i : adj.get(node)){
            if(visited[i] == false){
                dfs(i,adj,visited);
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna