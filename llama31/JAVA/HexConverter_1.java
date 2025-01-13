import java.lang.String;

public class HexConverter_1_1 {
    private static final int[] charValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15};

    public static byte hexCharToByte(char c) {
        if (c < '0' || c > 'f') {
            throw new IllegalArgumentException();
        }
        byte result = (byte) charValues[c - '0'];
        if (result < 0) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public static void main(String[] args) {
    }
}