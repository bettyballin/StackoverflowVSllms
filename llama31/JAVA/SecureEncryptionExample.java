import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class SecureEncryptionExample {
    public static void main(String[] args) throws Exception {
        // Generate a secure random key and IV
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32]; // 256-bit key
        random.nextBytes(key);
        byte[] iv = new byte[16]; // 128-bit IV
        random.nextBytes(iv);

        // Create an AES cipher instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Encrypt the data
        byte[] plaintext = "Hello, World!".getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] ciphertext = cipher.doFinal(plaintext);

        // Decrypt the data
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decrypted = cipher.doFinal(ciphertext);
        System.out.println(new String(decrypted));
    }
}