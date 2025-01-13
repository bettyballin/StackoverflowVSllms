import java.lang.String;
import java.security.SecureRandom;

public class SecureKeyGeneration {
    public static void main(String[] args) {
        // Create a new SecureRandom instance
        SecureRandom secureRandom = new SecureRandom();

        // Generate a 256-bit (32-byte) secure random key
        byte[] key = new byte[32];
        secureRandom.nextBytes(key);

        // Use the generated key for encryption
    }
}