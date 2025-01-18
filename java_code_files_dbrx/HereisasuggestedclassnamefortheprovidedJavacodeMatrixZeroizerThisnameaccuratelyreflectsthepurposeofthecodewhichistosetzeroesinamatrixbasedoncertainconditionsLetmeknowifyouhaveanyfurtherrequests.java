import java.lang.String;
public class MatrixZeroizer {
    public void setZeroes(int[][] matrix) {
        boolean isRow = false, isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int j = 0; j < C; j++) // Check if first column contains zero and also check if rows contain zeroes
            if (matrix[0][j] == 0)
                isCol = true;

        for (int i = 0; i < R; i++) { // Check if first row contains zero
            if (matrix[i][0] == 0)
                isRow = true;
            for (int j = 1; j < C; j++) // Scan the rows and mark them in the first column
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
        }

        for (int i = 1; i < R; i++) { // Iterate and make all zeros where first row/column has zero
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // If any zeros were there in the first row or column
        if (isRow) {
            for (int j = 1; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
    }
}