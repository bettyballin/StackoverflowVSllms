import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main_74 {
    public static void main(String[] args) throws Exception {
        // Generate a random nonce (128-bit)
        SecureRandom random = new SecureRandom();
        byte[] nonce = new byte[16];
        random.nextBytes(nonce);

        // Use the nonce as the IV for AES encryption
        IvParameterSpec ivSpec = new IvParameterSpec(nonce);
        SecretKeySpec keySpec = new SecretKeySpec("your_password".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        // Encrypt the data
        byte[] encryptedData = cipher.doFinal("your_data".getBytes());

        // Append the nonce to the encrypted data
        byte[] result = new byte[nonce.length + encryptedData.length];
        System.arraycopy(nonce, 0, result, 0, nonce.length);
        System.arraycopy(encryptedData, 0, result, nonce.length, encryptedData.length);

        // Print the result (optional)
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}