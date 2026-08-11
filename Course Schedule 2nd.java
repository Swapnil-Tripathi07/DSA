class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int V = numCourses;
        for(int i = 0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it : prerequisites){
            int u = it[0];
            int v = it[1];
            adj.get(v).add(u);
        }
        int[] inDegree = new int[V];
        for(int i= 0 ; i<V ; i++){
            for(int v : adj.get(i)){
                inDegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<V ; i++){
            if(inDegree[i] == 0){
                q.offer(i);
                count++;
            }
        }

        while(!q.isEmpty()){
           int v = q.poll();
           result.add(v);
           for(int nei : adj.get(v)){
                inDegree[nei]--;
                if(inDegree[nei] == 0){
                    q.offer(nei);
                    count++;
                }
           }
        }

        int[] res = new int[result.size()];
        for(int i = 0 ; i<result.size() ; i++){
            res[i] = result.get(i);
        }

        if(count == V){
            return res;
        }
        else{
            return new int[]{};
        }
    }
}
