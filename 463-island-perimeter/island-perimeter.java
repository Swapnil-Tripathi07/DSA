class Solution {

    int perimeter = 0;

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    a = i;
                    b = j;
                    break;
                }
            }
            if (grid[a][b] == 1) {
                break;
            }
        }

        dfs(a, b, visited, grid);

        return perimeter;
    }

    public void dfs(int i, int j, boolean[][] visited, int[][] grid) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            perimeter++;
            return;
        }

        if (grid[i][j] == 0) {
            perimeter++;
            return;
        }

        if (visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;

        dfs(i - 1, j, visited, grid);
        dfs(i, j + 1, visited, grid);
        dfs(i + 1, j, visited, grid);
        dfs(i, j - 1, visited, grid);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna