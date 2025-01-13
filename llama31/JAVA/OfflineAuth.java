import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Arrays;

public class OfflineAuth {
    public static void main(String[] args) throws Exception {
        // Generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        // Hash the password with the salt
        String password = "mysecretpassword";
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = f.generateSecret(spec).getEncoded();

        // Store the salt and hash on the client-side
        // ...

        // When the user enters their password, calculate the hash and compare
        String userInput = "mysecretpassword";
        KeySpec spec2 = new PBEKeySpec(userInput.toCharArray(), salt, 10000, 256);
        byte[] calculatedHash = f.generateSecret(spec2).getEncoded();
        if (Arrays.equals(hash, calculatedHash)) {
            System.out.println("Authenticated!");
        } else {
            System.out.println("Invalid password");
        }
    }
}