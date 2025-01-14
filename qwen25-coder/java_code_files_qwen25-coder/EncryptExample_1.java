import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Provider;
import java.security.Security;

public class EncryptExample {
    public static void main(String[] args) throws Exception {
        // Example key and initialization vector (IV) generation
        byte[] keyBytes = "0123456789abcdef".getBytes(); // 16-byte key for AES-128
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        byte[] ivBytes = "fede2ccf348c2a7d".getBytes(); // Initialization vector
        IvParameterSpec ivspec = new IvParameterSpec(ivBytes);

        // Obtain a security provider
        Provider provider = Security.getProviders()[0];

        Cipher encrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", provider);
        encrypt.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);

        // Define the plaintext to encrypt
        String plainTxt = "This is a test message.";
        byte[] encrypted = encrypt.doFinal(plainTxt.getBytes());

        // Output the encrypted data (Base64 encoded for readability)
        String encryptedText = java.util.Base64.getEncoder().encodeToString(encrypted);
        System.out.println("Encrypted text: " + encryptedText);
    }
}