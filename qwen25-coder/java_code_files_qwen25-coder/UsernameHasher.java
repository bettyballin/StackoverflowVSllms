import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class UsernameHasher {
    private static final int SALT_LENGTH = 16; // Salt length in bytes

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    public static String hashWithSalt(String username, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(salt); // Add salt
        byte[] hash = digest.digest(username.getBytes()); // Hash with salt

        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            String username = "exampleUser";
            byte[] salt = generateSalt();
            String hashedUsername = hashWithSalt(username, salt);
            
            System.out.println("Salt: " + bytesToHex(salt));
            System.out.println("Hashed Username: " + hashedUsername);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}