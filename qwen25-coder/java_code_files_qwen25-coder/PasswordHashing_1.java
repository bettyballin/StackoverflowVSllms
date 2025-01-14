import java.lang.String;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class PasswordHashing_1 {
    private static final int SALT_LENGTH = 16; // bytes

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    public static byte[] hashPassword(String password, byte[] salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return hashedPassword;
    }

    public static void main(String[] args) {
        try {
            String password = "securePassword";
            byte[] salt = generateSalt();
            byte[] hashedPassword = hashPassword(password, salt);

            System.out.println("Salt: " + java.util.Base64.getEncoder().encodeToString(salt));
            System.out.println("Hashed Password: " + java.util.Base64.getEncoder().encodeToString(hashedPassword));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}