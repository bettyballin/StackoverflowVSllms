import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64DecodeExample {
    public static void main(String[] args) {
        // Example Base64 encoded string
        String encodedData = "SGVsbG8gV29ybGQh"; // "Hello World!"

        // Decode the Base64 encoded string
        byte[] decodedData = Base64.getDecoder().decode(encodedData);

        // Convert decoded bytes to a String using UTF-8 encoding
        String result = new String(decodedData, StandardCharsets.UTF_8); // assuming UTF-8 encoding

        // Output the result
        System.out.println("Decoded string: " + result);
    }
}