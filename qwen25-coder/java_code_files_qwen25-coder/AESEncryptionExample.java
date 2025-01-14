import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class AESEncryptionExample {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for strong security
        SecretKey secretKey = keyGen.generateKey();

        byte[] iv = new byte[16]; // AES block size
        IvParameterSpec ivParams = new IvParameterSpec(iv);
        
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);
        byte[] encryptedBytes = cipher.doFinal("Data to encrypt".getBytes());
        
        String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Text: " + encryptedString);

        // For decryption you can use a similar block swapping ENCRYPT_MODE for DECRYPT_MODE
    }
}