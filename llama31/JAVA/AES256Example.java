import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class AES256Example {
    public static void main(String[] args) throws Exception {
        String data = "Hello, World!";
        String password = "mysecretpassword";

        // Generate a secret key
        Key key = new SecretKeySpec(password.getBytes(), "AES");

        // Create a Cipher instance
        Cipher cipher = Cipher.getInstance("AES");

        // Encrypt the data
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] ciphertext = cipher.doFinal(data.getBytes());

        // Decrypt the data
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plaintext = cipher.doFinal(ciphertext);

        System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));
        System.out.println("Plaintext: " + new String(plaintext));
    }
}