class Solution {
    public boolean validPath(int n, int[][] edges, int source, int des) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count = 0;

        boolean[] visited = new boolean[n];

        // return dfs(source,visited,adj,des); 
        return bfs(source,visited,adj,des);

    
    }

    public boolean dfs(int u  , boolean[] visited , ArrayList<ArrayList<Integer>> adj , int des){
        if(u == des){
            return true;
        }
        visited[u] = true;

        for(int it : adj.get(u)){
            if(visited[it] == false){
                visited[it] = true;
                if(dfs(it,visited,adj,des)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(int u , boolean[] visited , ArrayList<ArrayList<Integer>> adj , int des){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            if(des == node){
                return true;
            }

            for(Integer i : adj.get(node)){
                if(visited[i] == false){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return false;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna