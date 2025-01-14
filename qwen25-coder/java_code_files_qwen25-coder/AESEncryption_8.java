import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryption_8 {
    public static void main(String[] args) throws Exception {
        String original = "Hello World";
        byte[] keyBytes = new byte[16]; // For AES-128
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // PKCS5 is equivalent to PKCS7 for block size <= 8 bytes
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        
        byte[] encrypted = cipher.doFinal(original.getBytes());
        String encoded = Base64.getEncoder().encodeToString(encrypted);
        
        System.out.println("Original: " + original);
        System.out.println("Encrypted (Base64): " + encoded);
    }
}