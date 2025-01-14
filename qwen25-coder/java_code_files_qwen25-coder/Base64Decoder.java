import java.lang.String;
import java.util.Base64;

public class Base64Decoder {
    public static void main(String[] args) {
        String base64Encoded = "SGVsbG8gV29ybGQh"; // Example Base64 encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
        String decodedString = new String(decodedBytes);
        System.out.println(decodedString); // Outputs: Hello World!
    }
}