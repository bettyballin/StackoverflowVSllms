import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class Main_574 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Server-side
        String username = "john";
        String hashedPassword = hashPassword("mysecretpassword", "salt123");
        String salt = "salt123";

        // Send nonce to client
        String nonce = generateNonce();

        // Client-side
        String clientHashedPassword = hashPassword("mysecretpassword", salt, nonce);

        // Send authorization header
        System.out.println("Authorization: CustomAuth username=\"" + username + "\", hashedPassword=\"" + clientHashedPassword + "\", salt=\"" + salt + "\"");

        // Server-side verification
        String serverHashedPassword = hashPassword(hashedPassword, salt, nonce);
        if (serverHashedPassword.equals(clientHashedPassword)) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        return hashPassword(password, salt, null);
    }

    public static String hashPassword(String password, String salt, String nonce) throws NoSuchAlgorithmException {
        String input = password + salt + (nonce != null ? nonce : "");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String generateNonce() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}