import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.nio.charset.CharsetDecoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UTF8Checker {
    public static boolean isUTF8(byte[] bytes) {
        try {
            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
            decoder.decode(ByteBuffer.wrap(bytes));
        } catch (Exception ex) {
            return false; // If an exception occurs, it's not valid UTF-8
        }
        return true;
    }

    public static void main(String[] args) {
        byte[] utf8Bytes = "Hello world!".getBytes(StandardCharsets.UTF_8);
        System.out.println("Is UTF-8: " + isUTF8(utf8Bytes)); // Should print: Is UTF-8: true

        byte[] invalidUtf8Bytes = {(byte) 0xFF, (byte) 0xFE}; // This is not valid UTF-8
        System.out.println("Is UTF-8: " + isUTF8(invalidUtf8Bytes)); // Should print: Is UTF-8: false
    }
}