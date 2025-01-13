import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Main_123 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Generate a random salt
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        // Hash the password with PBKDF2
        String password = "userPassword";
        int iterations = 10000;
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, 256);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = f.generateSecret(spec).getEncoded();

        // Store the salt and hash in your database
        System.out.println("Salt: " + bytesToHex(salt));
        System.out.println("Hash: " + bytesToHex(hash));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}