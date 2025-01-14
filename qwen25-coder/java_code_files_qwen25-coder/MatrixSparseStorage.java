import java.lang.String;
public class MatrixSparseStorage {
    boolean[] zeroRows;
    boolean[] zeroColumns;
    int[][] matrix;
    
    public MatrixSparseStorage(int n, int m) {
        zeroRows = new boolean[n];
        zeroColumns = new boolean[m];
        matrix = new int[n][m];
        // Initialize matrix elements as needed
    }
    
    public void setZeroRow(int row) {
        zeroRows[row] = true;
    }
    
    public void setZeroColumn(int col) {
        zeroColumns[col] = true;
    }
    
    public int getElement(int i, int j) {
        if (zeroRows[i] || zeroColumns[j]) return 0;
        // Otherwise, retrieve the value from matrix
        return matrix[i][j];
    }
    
    public static void main(String[] args) {
    }
}