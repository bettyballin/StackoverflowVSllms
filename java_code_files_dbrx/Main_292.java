import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String plainText = "activation_key";
        String encodedKey = Base64.getEncoder().encodeToString(plainText.getBytes());
        // ...save the encodedKey in a user-specific location...
    }
}