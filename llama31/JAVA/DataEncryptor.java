import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;

public class DataEncryptor {
    public static void main(String[] args) throws Exception {
        // Define the secret key and initialization vector (IV)
        byte[] secretKeyBytes = "your_secret_key_here".getBytes();
        byte[] ivBytes = "your_iv_here".getBytes();

        // Create a SecretKeySpec and IvParameterSpec
        SecretKeySpec secretKey = new SecretKeySpec(secretKeyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // Use a secure encryption algorithm (e.g., AES)
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        // Define sensitive data to encrypt
        String sensitiveData = "your_sensitive_data_here";

        // Encrypt sensitive data
        byte[] encryptedData = cipher.doFinal(sensitiveData.getBytes());

        // Print the encrypted data
        System.out.println("Encrypted data: " + new String(encryptedData));
    }
}