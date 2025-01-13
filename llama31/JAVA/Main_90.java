import java.lang.String;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Main_90 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "mysecretpassword";
        byte[] salt = "mysalt".getBytes();

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 128);
        byte[] key = factory.generateSecret(spec).getEncoded();

        // Use the derived key
        System.out.println(key.length);
    }
}