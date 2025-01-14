import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SecureSecrets {
    private static final String SECRET_KEY = "MySuperSecureKey123"; // Must be kept secret!

    public static String encrypt(String plainText) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        return new String(cipher.doFinal(decodedBytes));
    }

    public static void main(String[] args) throws Exception {
        String sensitiveData = "mySecretPassword";
        String encrypted = encrypt(sensitiveData);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}