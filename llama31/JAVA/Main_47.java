// Example of AES encryption in Java
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class Main_47 {
    public static void main(String[] args) throws Exception {
        // Encryption
        String key = "Your Secret Key";
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        String plainText = "This is a secret message";
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        System.out.println("Encrypted text: " + new String(encryptedBytes, StandardCharsets.UTF_8));

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        System.out.println("Decrypted text: " + new String(decryptedBytes, StandardCharsets.UTF_8));
    }
}