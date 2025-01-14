import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SecureConnection_1 {

    // Example key for AES encryption (replace with a secure way to handle your key)
    private static final String SECRET_KEY = "ThisIsASecretKey";

    public static void main(String[] args) {
        try {
            String partialPasswordEnv = System.getenv("PARTIAL_PASSWORD");
            if (partialPasswordEnv == null || partialPasswordEnv.isEmpty()) {
                throw new IllegalArgumentException("Environment variable PARTIAL_PASSWORD is not set.");
            }

            // Assume full password is the concatenation of environment and hard-coded parts
            String encryptedPartialPassword = encrypt(partialPasswordEnv, SECRET_KEY);
            
            // Example usage: concatenate with another part or use whole as needed
            String finalPassword = "staticPart" + encryptedPartialPassword;

            // Now you can use finalPassword for your connection logic
            connectToFtp("user", finalPassword);

        } catch (Exception e) {
            System.err.println("Error handling secure password: " + e.getMessage());
        }
    }

    private static String encrypt(String value, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static void connectToFtp(String username, String password) {
        // FTP connection logic here
        System.out.println("Connecting to FTP with user: " + username + ", and encrypted partial password.");
    }
}