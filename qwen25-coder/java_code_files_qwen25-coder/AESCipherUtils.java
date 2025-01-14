import java.security.SecureRandom;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class AESCipherUtils {
    // Example function to encrypt data
    byte[] encryptData(byte[] plaintext, byte[] secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[cipher.getBlockSize()];
        random.nextBytes(iv);

        IvParameterSpec spec = new IvParameterSpec(iv);
        Key key = new SecretKeySpec(secretKey, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        byte[] ciphertext = cipher.doFinal(plaintext);

        // Concatenate IV and ciphertext
        return concatenate(iv, ciphertext);
    }

    // Example function to decrypt data
    byte[] decryptData(byte[] ivAndCiphertext, byte[] secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        int blockSize = cipher.getBlockSize();
        byte[] iv = Arrays.copyOfRange(ivAndCiphertext, 0, blockSize);
        byte[] ciphertext = Arrays.copyOfRange(ivAndCiphertext, blockSize, ivAndCiphertext.length);

        IvParameterSpec spec = new IvParameterSpec(iv);
        Key key = new SecretKeySpec(secretKey, "AES");
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        return cipher.doFinal(ciphertext);
    }

    // Helper function to concatenate arrays
    byte[] concatenate(byte[] a, byte[] b) {
        byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    public static void main(String[] args) {
        // Main method can be used for testing
    }
}