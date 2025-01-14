import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtils {

    private static final SecureRandom random = new SecureRandom();
    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateSalt(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static byte[] hash(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte[] hashedPassword = md.digest(password.getBytes());
        return hashedPassword;
    }

    // Example usage
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "mySecurePassword";
        String salt = generateSalt(16); // 16 characters long salt for example

        byte[] hashedPassword = hash(password, salt);

        System.out.println("Generated Salt: " + salt);
        System.out.println("Hashed Password: " + java.util.Base64.getEncoder().encodeToString(hashedPassword));
    }
}