import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHasher_2 {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int SALT_LENGTH = 16; // 128 bits

    public static byte[] generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        RANDOM.nextBytes(salt);
        return salt;
    }

    public static byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes());
        return hash;
    }

    // Example usage
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "strongPassword123!";
        byte[] salt = generateSalt();
        byte[] hashedPassword = hashPassword(password, salt);
        
        System.out.println("Salt: " + bytesToHex(salt));
        System.out.println("Hashed Password: " + bytesToHex(hashedPassword));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}