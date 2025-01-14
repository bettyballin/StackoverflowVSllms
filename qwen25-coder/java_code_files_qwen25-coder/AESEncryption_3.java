import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class AESEncryption_3 {
    public static void main(String[] args) throws Exception {
        String data = "Hello, World!";
        
        // Generate a Secret Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example
        SecretKey secretKey = keyGen.generateKey();
        
        // Generate an Initialization Vector (IV)
        byte[] iv = new byte[16]; // AES block size
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        
        // Initialize Cipher in Encryption Mode
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        
        byte[] encrypted = cipher.doFinal(data.getBytes());
        String encodedEncryptedData = Base64.getEncoder().encodeToString(encrypted);
        String encodedIV = Base64.getEncoder().encodeToString(iv);
        
        System.out.println("Encrypted Data: " + encodedEncryptedData);
        System.out.println("Initialization Vector (IV): " + encodedIV);
    }
}