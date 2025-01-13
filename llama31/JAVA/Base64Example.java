import java.lang.String;
import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded: " + encodedString);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded: " + decodedString);
    }
}