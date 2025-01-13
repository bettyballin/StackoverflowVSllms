import java.lang.String;
public class SparseMatrix {
    private int[][] matrix;
    private boolean[] rowsZeroed;
    private boolean[] colsZeroed;

    public SparseMatrix(int n, int m) {
        matrix = new int[n][m];
        rowsZeroed = new boolean[n];
        colsZeroed = new boolean[m];
    }

    public void zeroRow(int row) {
        rowsZeroed[row] = true;
    }

    public void zeroCol(int col) {
        colsZeroed[col] = true;
    }

    public int get(int row, int col) {
        if (rowsZeroed[row] || colsZeroed[col]) {
            return 0;
        } else {
            return matrix[row][col];
        }
    }

	public static void main(String[] args) {
	}
}