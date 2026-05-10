class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int row = 0, col = 0;
        int endRow = n - 1, endCol = n - 1;
        while (row <= endRow && col <= endCol) {
            for (int i = col; i <= endCol; i++) {
                matrix[row][i] = count++;
            }
            row++;
            for (int i = row; i <= endRow; i++) {
                matrix[i][endCol] = count++;
            }
            endCol--;
            if (row <= endRow) {
                for (int i = endCol; i >= col; i--) {
                    matrix[endRow][i] = count++;
                }
                endRow--;
            }
            if (col <= endCol) {
                for (int i = endRow; i >= row; i--) {
                    matrix[i][col] = count++;
                }
                col++;
            }
        }
        return matrix;
    }
}