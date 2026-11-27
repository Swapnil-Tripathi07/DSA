class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int freshOrange = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        if(freshOrange == 0){
            return 0;
        }

        int minutes = 0;

        int[] dirX = { -1, 0, 1, 0 };
        int[] dirY = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] pair = q.poll();
                int a = pair[0];
                int b = pair[1];

                for (int k = 0; k < 4; k++) {
                    int newX = a + dirX[k];
                    int newY = b + dirY[k];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshOrange--;
                        q.add(new int[] { newX, newY });
                    }
                }
            }
            minutes++;
        }

        if (freshOrange == 0) {
            return minutes - 1;
        } else {
            return -1;
        }
    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna