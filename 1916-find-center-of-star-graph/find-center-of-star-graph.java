// class Solution {
//     public int findCenter(int[][] edges) {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         int n = edges.length+1;

//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < edges.length; i++) {
//             int u = edges[i][0];
//             int v = edges[i][1];

//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }
    

//         boolean[] visited = new boolean[n+1];
//         int[] count = new int[n+1];

//         dfs(1,visited,adj,count);

//         int max = Integer.MIN_VALUE;
//         int index = 0;

//         for(int i= 0 ; i<count.length ; i++){
//             if(count[i] > max){
//                 max = count[i];
//                 index = i;
//             }
//         }
//         return index;
//     }

//     public void dfs(int u , boolean[] visited , ArrayList<ArrayList<Integer>> adj, int[] count){
//         if(visited[u] == true){
//             count[u]++;
//             return;
//         }
//         visited[u] = true;


//         for(int it : adj.get(u)){
//             if(visited[it] == false){
//                 dfs(it,visited,adj,count);
//             }
//         }


//     }
// }


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

        dfs(1, visited, adj, count);

        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (count[i] > max) {
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
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna