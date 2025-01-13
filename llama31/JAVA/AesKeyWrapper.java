import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AesKeyWrapper {
    // Key wrapping using AES-KW
    public static byte[] wrap(byte[] key, byte[] userPassword) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(userPassword, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(key);
    }

    public static void main(String[] args) throws Exception {
        // Generate a random key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128, new SecureRandom());
        SecretKey key = keyGen.generateKey();

        // Generate a user password
        byte[] userPassword = "mysecretpassword".getBytes();

        // Wrap the key
        byte[] wrappedKey = wrap(key.getEncoded(), userPassword);

        // Print the wrapped key
        System.out.println("Wrapped Key: " + Base64.getEncoder().encodeToString(wrappedKey));
    }
}