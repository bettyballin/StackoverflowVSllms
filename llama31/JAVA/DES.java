import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class DES {
    public static void main(String[] args) throws Exception {
        // Generate a 56-bit key
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56, new SecureRandom());
        SecretKey key = keyGen.generateKey();

        // Encrypt data
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] plaintext = "Hello World".getBytes();
        byte[] ciphertext = cipher.doFinal(plaintext);

        // Decrypt data
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(ciphertext);

        System.out.println("Plaintext: " + new String(plaintext));
        System.out.println("Ciphertext: " + new String(ciphertext));
        System.out.println("Decrypted: " + new String(decrypted));
    }
}