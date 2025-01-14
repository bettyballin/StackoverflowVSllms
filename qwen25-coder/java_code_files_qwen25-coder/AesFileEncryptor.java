import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesFileEncryptor {
    // Example: Using AES for file encryption.
    public static void main(String[] args) throws Exception {
        String key = "mysecretpassword";
        String plainText = "Hello World";

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());

        // Optionally, print the encrypted text
        System.out.println("Encrypted text: " + new String(encrypted));
    }
}