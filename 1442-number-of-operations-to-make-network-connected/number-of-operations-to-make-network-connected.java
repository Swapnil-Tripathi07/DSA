class Solution {
    private int[] parent;
    private int[] rank;

    int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); // Path compression
    }

    void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        // Union by rank
        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }


    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){ //Minimum n-1 edges to chahiye hongi n nodes ko connect karne ke liye
            return -1;
        }
        parent = new int[n];
        rank = new int[n];

        for(int i = 0 ; i<n ; i++){
            parent[i] = i;
        }
        
        int components = n;
        for(int[] v : connections){
            if(find(v[0]) != find(v[1])){
                union(v[0],v[1]);
                components--;
            }
        }
        return components-1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna