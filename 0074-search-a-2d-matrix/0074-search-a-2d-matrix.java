class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Binary search to find the correct row
        int start = 0, end = rows - 1;
        int row = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == matrix[mid][0]) {
                return true;  // Found at start of mid row
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // After the loop, 'end' will be the row where target could be (or -1 if smaller than first element)
        row = end;
        if (row < 0) return false; // target is smaller than all first elements

        // Binary search within the identified row
        start = 0;
        end = cols - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}