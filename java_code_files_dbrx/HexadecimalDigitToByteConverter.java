import java.lang.String;
public class HexadecimalDigitToByteConverter {
    public static byte res = 0;
    public static byte hexDigitToByte(char c) {
        byte res = 0;
        if (c >= '0' && c <= '9') {
            res = (byte)(c - '0');
        } else if (c >= 'a' && c <= 'f') {
            res = (byte)(c - 'a' + 10);
        } else if (c >= 'A' && c <= 'F') {
            res = (byte)(c - 'A' + 10);
        }
        return res;
    }
    public static void main(String[] args) {
    }
}