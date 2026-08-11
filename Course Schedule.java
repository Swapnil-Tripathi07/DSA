class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;
        for(int i = 0 ; i<V ; i++){
            adj.add( new ArrayList<>());
        }
        for(int[] it : pre){
            int u = it[0];
            int v = it[1];
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for(int i = 0 ; i<V ; i++){
            if(!visited[i] && isCycleDfs(i,adj,visited,inRecursion)){
                return false;
            }
        }
        return true;
    }

    public boolean isCycleDfs(int u , ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] inRecursion){
        visited[u] = true;
        inRecursion[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v] && isCycleDfs(v,adj,visited,inRecursion)){
                return true;
            }
            else if(inRecursion[v]){
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }
}
