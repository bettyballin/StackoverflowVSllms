import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption_4 {
    public static void main(String[] args) throws Exception {
        String originalString = "SensitiveInfo";
        
        // Generate a Secret Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for example
        SecretKey secretKey = keyGen.generateKey();
        
        // Encrypt the string
        byte[] encodedKey = secretKey.getEncoded();
        SecretKeySpec originalKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, originalKey);
        byte[] encryptedByteString = cipher.doFinal(originalString.getBytes());
        
        // Decrypt the string
        cipher.init(Cipher.DECRYPT_MODE, originalKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedByteString);
        
        System.out.println("Original String: " + originalString);
        System.out.println("Decrypted String: " + new String(decryptedBytes));
    }
}