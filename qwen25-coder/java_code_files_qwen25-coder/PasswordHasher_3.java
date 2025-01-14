import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher_3 {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            String password = "mySecurePassword123";
            String hashedPassword = hashPassword(password);
            System.out.println("Hashed Password: " + hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}