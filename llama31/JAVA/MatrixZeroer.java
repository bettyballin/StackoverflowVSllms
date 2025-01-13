import java.lang.String;

public class MatrixZeroer {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];

        // Mark rows and cols that need to be zeroed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Zero out marked rows and cols
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        MatrixZeroer mz = new MatrixZeroer();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        mz.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}