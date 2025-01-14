import java.lang.String;
import java.util.Base64;

public class Base64Example_2 {
    public static void main(String[] args) {
        byte[] encryptedBytes = new byte[33]; // Example encrypted data of length 33
        String encodedString = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encoded string length: " + encodedString.length());
    }
}