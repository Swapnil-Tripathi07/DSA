class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = edges.length + 1;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        int[] count = new int[n + 1];

        // dfs(1, visited, adj, count); //Through DFS
        bfs(1,visited,adj,count);   //Through BFS

        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (count[i] >= max) {
                max = count[i];
                index = i;
            }
        }

        return index;
    }

    public void dfs(int u, boolean[] visited,ArrayList<ArrayList<Integer>> adj, int[] count) {

        if (visited[u]) {
            return;
        }

        visited[u] = true;

        count[u] = adj.get(u).size();

        for (int it : adj.get(u)) {
            if (!visited[it]) {
                dfs(it, visited, adj, count);
            }
        }
    }

    public static void bfs(int u , boolean[] visited , ArrayList<ArrayList<Integer>> adj, int[] count){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u] = true;
        count[u] = count[u] + 1;

        while(!q.isEmpty()){
            Integer node = q.poll();

            for(Integer i : adj.get(node)){
                if(visited[i] == false){
                    visited[i] = true;
                    count[i] = count[i] + 1;
                    q.add(i);
                }
                else{
                    count[i] = count[i] + 1;
                }   
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna