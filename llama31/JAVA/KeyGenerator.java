import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyGenerator {
    // Insecure way to create a DES key using a salted hash
    String secretKey = "my_secret_key";
    String salt = "my_salt";
    byte[] key;

    public KeyGenerator() throws NoSuchAlgorithmException {
        key = MessageDigest.getInstance("MD5").digest((secretKey + salt).getBytes());
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        new KeyGenerator();
    }
}