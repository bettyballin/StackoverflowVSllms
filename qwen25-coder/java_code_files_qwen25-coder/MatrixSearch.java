import java.lang.String;
public class MatrixSearch {
    public int[] searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1}; // Element not found
        }
        
        int row = 0;
        int col = matrix[0].length - 1; // Start at the top-right corner
        
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col}; // Target found
            } else if (matrix[row][col] > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        
        return new int[]{-1, -1}; // Element not found
    }

    public static void main(String[] args) {
        MatrixSearch ms = new MatrixSearch();
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        
        int[] result = ms.searchMatrix(matrix, 5);
        if (result[0] != -1) {
            System.out.println("Element found at: (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("Element not found.");
        }
    }
}