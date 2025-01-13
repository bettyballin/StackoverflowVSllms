import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class PasswordAuthenticator {

    // Client-side
    String password = "mysecretpassword";
    String salt = "randomsaltvalue";
    String nonce = generateNonce(); // using a CSPRNG

    String hashedPassword = hashPassword(password, salt); // e.g., PBKDF2
    String sessionToken = hash(hashedPassword + nonce); // e.g., SHA-256

    // Send sessionToken to the server

    public static void main(String[] args) {
        PasswordAuthenticator authenticator = new PasswordAuthenticator();
        System.out.println(authenticator.sessionToken);
    }

    private String generateNonce() {
        SecureRandom random = new SecureRandom();
        byte[] nonceBytes = new byte[16];
        random.nextBytes(nonceBytes);
        return bytesToHex(nonceBytes);
    }

    private String hashPassword(String password, String salt) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
            byte[] hashedPasswordBytes = factory.generateSecret(spec).getEncoded();
            return bytesToHex(hashedPasswordBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}