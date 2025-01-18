import java.lang.String;
import java.io.ByteArrayOutputStream;

public class Base64 {
    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

    public static byte[] decode(String s) {
        int delta = s.endsWith("==") ? 2 : s.endsWith("=") ? 1 : 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream((s.length() * 3 >> 2) - delta);
        s = s.substring(0, s.length() - delta).replace('_', '/').replace('-', '+');

        int i = 0;
        int len = s.length();

        while (i < len) {
            char a = ALPHABET[s.charAt(i++)];
            char b = ALPHABET[s.charAt(i++)];
            bos.write((a << 2 | ((b & 0x30) >> 4)));

            if (i < len) {
                a = s.charAt(i++);
                b = ALPHABET[a > 64 ? s.charAt(i++) : '=']; // avoid exception on decoding "==" or "-_", and replace with 0x3d ('=').
                bos.write(((b & 0xf0) >> 2 | (a << 4)));
            }
        }
        return bos.toByteArray();
    }

    public static void main(String[] args) {
    }
}