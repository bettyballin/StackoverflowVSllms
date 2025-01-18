import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

public class MyCipherClass {

    private Cipher ecipher;
    private Cipher dcipher;
    private Key key;
    private IvParameterSpec iv;

    public MyCipherClass() throws Exception {
        // Initialize key and IV (for example purposes only; in practice, use secure random values)
        byte[] keyBytes = new byte[16]; // Example key bytes
        byte[] ivBytes = new byte[16];  // Example IV bytes
        key = new SecretKeySpec(keyBytes, "AES");
        iv = new IvParameterSpec(ivBytes);

        // Initialize ciphers
        ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public void encrypt(OutputStream out) throws Exception {
        // Other encryption setup code...
        ecipher.init(Cipher.ENCRYPT_MODE, key, iv);     // Add this line before using 'ecipher'
        out = new CipherOutputStream(out, ecipher);
        // Continue with encryption...
    }

    public void decrypt(InputStream in) throws Exception {
        // Other decryption setup code...
        dcipher.init(Cipher.DECRYPT_MODE, key, iv);     // Add this line before using 'dcipher'
        in = new CipherInputStream(in, dcipher);
        // Continue with decryption...
    }

    // You can add main method or other methods if needed
}