import java.lang.String;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PasswordStorage {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "mysecretpassword";
        String salt = "randomsaltvalue";

        // Hash the password
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 10000, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();

        // Store the hashed password and salt
        // ...

        // Verify the password
        String inputPassword = "mysecretpassword";
        KeySpec inputSpec = new PBEKeySpec(inputPassword.toCharArray(), salt.getBytes(), 10000, 128);
        byte[] inputHash = f.generateSecret(inputSpec).getEncoded();

        if (java.util.Arrays.equals(hash, inputHash)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }
}