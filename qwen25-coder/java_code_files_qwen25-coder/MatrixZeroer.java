import java.lang.String;

public class MatrixZeroer {
    public void setMatrixZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;

        // Use two boolean variables to check if we need to zero out the first row and column
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

        // Check if the first row needs to be zeroes
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        // Check if the first column needs to be zeroes
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }

        // Use first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Set zeroes using the markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (isFirstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (isFirstColumnZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
    }
}