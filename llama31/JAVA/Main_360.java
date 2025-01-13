import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main_360 {
    public static void main(String[] args) throws Exception {
        String sensitiveData = "creditCardNumber";
        String encryptionKey = "your_secret_key_here";

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptionKey.getBytes(), "AES"));
        byte[] encryptedData = cipher.doFinal(sensitiveData.getBytes());

        // Store the encrypted data
        System.out.println("Encrypted data: " + java.util.Arrays.toString(encryptedData));
    }
}