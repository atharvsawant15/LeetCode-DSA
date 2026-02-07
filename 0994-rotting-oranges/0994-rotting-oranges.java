// class Solution {

//     // Add zero border
//     public static int[][] addZeroBorder(int[][] arr) {
//         int m = arr.length;
//         int n = arr[0].length;

//         int[][] result = new int[m + 2][n + 2];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 result[i + 1][j + 1] = arr[i][j];
//             }
//         }

//         return result;
//     }

//     // Minute-by-minute simulation (no BFS)
//     public int orangesRotting(int[][] grid) {
//         int[][] newgrid = addZeroBorder(grid);
//         int minutes = 0;

//         boolean changed; // Did any orange rot this minute?

//         do {
//             changed = false;

//             // Mark oranges that will rot this minute with 3
//             for (int i = 1; i < newgrid.length - 1; i++) {
//                 for (int j = 1; j < newgrid[0].length - 1; j++) {
//                     if (newgrid[i][j] == 2) {
//                         if (newgrid[i - 1][j] == 1) { newgrid[i - 1][j] = 3; changed = true; }
//                         if (newgrid[i + 1][j] == 1) { newgrid[i + 1][j] = 3; changed = true; }
//                         if (newgrid[i][j - 1] == 1) { newgrid[i][j - 1] = 3; changed = true; }
//                         if (newgrid[i][j + 1] == 1) { newgrid[i][j + 1] = 3; changed = true; }
//                     }
//                 }
//             }

//             // Update all 3s to 2s (they rotted this minute)
//             for (int i = 1; i < newgrid.length - 1; i++) {
//                 for (int j = 1; j < newgrid[0].length - 1; j++) {
//                     if (newgrid[i][j] == 3) {
//                         newgrid[i][j] = 2;
//                     }
//                 }
//             }

//             if (changed) minutes++;

//         } while (changed);

//         // Check if any fresh orange remains
//         for (int i = 1; i < newgrid.length - 1; i++) {
//             for (int j = 1; j < newgrid[0].length - 1; j++) {
//                 if (newgrid[i][j] == 1) return -1;
//             }
//         }

//         return minutes;
//     }
// }


import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Add all initially rotten oranges to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0; // No fresh oranges to rot

        int minutes = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}}; // Up, Down, Left, Right

        // Step 2: BFS level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                // Check 4-directional neighbors
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // If neighbor is fresh, rot it
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) minutes++;
        }

        // Step 3: Check if any fresh oranges remain
        return freshCount == 0 ? minutes : -1;
    }
}
