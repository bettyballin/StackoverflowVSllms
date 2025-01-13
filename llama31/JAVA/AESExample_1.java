import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESExample_1 {
    public static void main(String[] args) throws Exception {
        // Generate a secure random key
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128); // 128-bit key size
        SecretKey key = kg.generateKey();

        // Encrypt a message
        String message = "Hello, World!";
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec params = new GCMParameterSpec(128, new byte[12]); // 128-bit IV
        cipher.init(Cipher.ENCRYPT_MODE, key, params);
        byte[] ciphertext = cipher.doFinal(message.getBytes());

        // Decrypt the ciphertext
        cipher.init(Cipher.DECRYPT_MODE, key, params);
        byte[] plaintext = cipher.doFinal(ciphertext);
        System.out.println(new String(plaintext));
    }
}