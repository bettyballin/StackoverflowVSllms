import java.lang.String;

public class ArrayInitializer {
    int[][] 二维Array = new int[50][8];
    int[][] 八个一维Arrays = new int[8][50];

    {
        // Initializing 二维Array
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 8; j++) {
                二维Array[i][j] = 1;
            }
        }

        // Initializing 八个一维Arrays
        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 50; i++) {
                八个一维Arrays[k][i] = 1;
            }
        }
    }

    public static void main(String[] args) {
    }
}