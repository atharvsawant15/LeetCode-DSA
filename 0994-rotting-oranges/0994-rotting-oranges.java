class Solution {

    // Add zero border
    public static int[][] addZeroBorder(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[][] result = new int[m + 2][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i + 1][j + 1] = arr[i][j];
            }
        }

        return result;
    }

    // Minute-by-minute simulation (no BFS)
    public int orangesRotting(int[][] grid) {
        int[][] newgrid = addZeroBorder(grid);
        int minutes = 0;

        boolean changed; // Did any orange rot this minute?

        do {
            changed = false;

            // Mark oranges that will rot this minute with 3
            for (int i = 1; i < newgrid.length - 1; i++) {
                for (int j = 1; j < newgrid[0].length - 1; j++) {
                    if (newgrid[i][j] == 2) {
                        if (newgrid[i - 1][j] == 1) { newgrid[i - 1][j] = 3; changed = true; }
                        if (newgrid[i + 1][j] == 1) { newgrid[i + 1][j] = 3; changed = true; }
                        if (newgrid[i][j - 1] == 1) { newgrid[i][j - 1] = 3; changed = true; }
                        if (newgrid[i][j + 1] == 1) { newgrid[i][j + 1] = 3; changed = true; }
                    }
                }
            }

            // Update all 3s to 2s (they rotted this minute)
            for (int i = 1; i < newgrid.length - 1; i++) {
                for (int j = 1; j < newgrid[0].length - 1; j++) {
                    if (newgrid[i][j] == 3) {
                        newgrid[i][j] = 2;
                    }
                }
            }

            if (changed) minutes++;

        } while (changed);

        // Check if any fresh orange remains
        for (int i = 1; i < newgrid.length - 1; i++) {
            for (int j = 1; j < newgrid[0].length - 1; j++) {
                if (newgrid[i][j] == 1) return -1;
            }
        }

        return minutes;
    }
}
