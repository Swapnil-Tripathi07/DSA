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

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for(int i = 0 ; i<26 ; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        //First do union of equal chars.
        for(String s : equations){ 
            if(s.charAt(1) == '='){    // "a==b"
                union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }

        //find not equal cases and check validity
        for(String s : equations){
            if(s.charAt(1) == '!'){    //"a!=b"
                char first = s.charAt(0);  //a
                char second = s.charAt(3); //b

                int parent_first = find(first-'a');
                int parent_second = find(second-'a');

                if(parent_first == parent_second){
                    return false;
                }
            }
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna