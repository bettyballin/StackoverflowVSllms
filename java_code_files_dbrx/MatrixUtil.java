import java.lang.String;
public class MatrixUtil {
    public static void swapElementsAtIndices(int[][] A, int i, int j, int y, int x){
        int tmp = A[x][i];
        A[x][i] = A[y][j];
        A[y][j] = tmp;
    }
    public static void main(String[] args) {
    }
}