import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class AESEncryption_7 {
    public static void main(String[] args) throws Exception {
        String originalString = "Hello, World!";
        
        // Generate a Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        
        // Initialize Cipher for Encryption
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]); // In real use, generate a random IV
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        
        // Encrypt the String
        byte[] encryptedBytes = cipher.doFinal(originalString.getBytes());
        
        // Encode to Base64 for URL safe transmission
        String encodedEncryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
        
        System.out.println("Original: " + originalString);
        System.out.println("Encoded Encrypted: " + encodedEncryptedString);
    }
}