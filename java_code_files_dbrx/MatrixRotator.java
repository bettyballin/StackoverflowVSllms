import java.lang.String;
public class MatrixRotator {
    public static int[][] rotate90(int[][] array) {
        int aLength = array.length;
        int bLength = array[0].length;

        // Transpose the array: swap column and row indexes
        for (int r = 0, len_r = aLength; r < len_r; ++r) {
            for (int c = 0, len_c = bLength; c < len_c - r; ++c) {
                int tmp = array[r][c];
                array[r][c] = array[bLength - 1 - c][aLength - 1 - r]; // rotate 90 degrees CCW
            }
        }

        for (int i = 0, len_t = aLength; i < len_t / 2; ++i) {
            System.arraycopy(array[i], 0, array[aLength - 1 - i], 0, bLength); // flip array to make it rotate 90 degrees CW
        }

        return array;
    }
    public static void main(String[] args) {
    }
}