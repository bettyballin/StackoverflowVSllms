import java.lang.String;
import java.util.Base64;

public class Base64Example_3 {
    public static void main(String[] args) {
        // Sample byte array with a null character
        byte[] originalBytes = new byte[]{0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x00, 0x21};

        // Encoding to Base64
        String encodedString = Base64.getEncoder().encodeToString(originalBytes);
        System.out.println("Encoded: " + encodedString);

        // Decoding from Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        System.out.println("Decoded: " + new String(decodedBytes, 0, decodedBytes.length -1)); // Exclude the null character for display purposes
    }
}