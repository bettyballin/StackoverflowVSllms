import java.lang.String;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

public class PBKDF2Example {
    public static byte[] deriveKey(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000; // You can adjust the iteration count as needed
        int keyLength = 128; // For a 16-byte key

        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
        byte[] secretKey = skf.generateSecret(spec).getEncoded();

        return secretKey;
    }

    public static void main(String[] args) {
        try {
            String secret = "yourPasswordHere";
            byte[] saltValueBytes = new byte[16]; // Example salt
            Arrays.fill(saltValueBytes, (byte) 0); // Populate with actual salt value

            byte[] derivedKey = deriveKey(secret, saltValueBytes);
            System.out.println("Derived Key: " + Base64.getEncoder().encodeToString(derivedKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}