class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){ // no need to traverse the whole image
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        int original = image[sr][sc];

        dfs(sr,sc,color,visited,image,original);
        
        return image;
    }

    public static void dfs(int i, int j, int color,  boolean[][] visited, int[][] grid,int ori) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        if (visited[i][j] == true || grid[i][j] != ori) {
            return;
        }

        visited[i][j] = true;
        grid[i][j] = color;

        dfs(i - 1, j,color, visited, grid,ori); //up    
        dfs(i, j + 1, color,visited, grid,ori); //right
        dfs(i + 1, j,color, visited, grid,ori); //down
        dfs(i, j - 1,color, visited, grid,ori); //left
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna