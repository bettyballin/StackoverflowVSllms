import java.security.SecureRandom;

public class DESKeyGenerator_1_1 {
    // Secure way to create a DES key
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[7]; // 56 bits = 7 bytes
        random.nextBytes(key);
    }
}