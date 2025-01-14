import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESEncryption_6 {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for example
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        String originalString = "Hello, World";
        byte[] encryptedBytes = cipher.doFinal(originalString.getBytes());
        System.out.println("Encrypted: " + new String(encryptedBytes));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        System.out.println("Decrypted: " + new String(decryptedBytes));
    }
}