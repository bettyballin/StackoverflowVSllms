import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class SecureStorage {
    public static void main(String[] args) throws Exception {
        // Generate a secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt the SSN/SIN
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String ssn = "123-45-6789";
        byte[] encryptedSsn = cipher.doFinal(ssn.getBytes());

        // Store the encrypted SSN/SIN
        // ...

        // Decrypt the SSN/SIN
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedSsn = cipher.doFinal(encryptedSsn);
        System.out.println(new String(decryptedSsn));
    }
}