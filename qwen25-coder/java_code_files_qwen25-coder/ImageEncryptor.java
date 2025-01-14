import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.SecureRandom;

public class ImageEncryptor {
    public static void main(String[] args) throws Exception {
        // Generate a key & IV securely
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for maximum security, though requires Java with unlimited strength jurisdiction policy files
        SecretKey secretKey = keyGen.generateKey();
        
        SecureRandom randomSecureRandom = new SecureRandom();
        byte[] iv = new byte[16]; 
        randomSecureRandom.nextBytes(iv);
        IvParameterSpec ivParams = new IvParameterSpec(iv);

        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);

        // Encrypt the file
        try (FileInputStream fis = new FileInputStream("path/to/your/image.jpg");
             FileOutputStream fos = new FileOutputStream("path/to/encrypted/image.enc");
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[8*1024]; // 8KB buffer
            int read;
            while ((read = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, read);
            }
        }

        // Save the IV for decryption (this should be stored securely alongside encryption key)
        try (FileOutputStream ivOut = new FileOutputStream("path/to/your/image.enc.iv")) {
            ivOut.write(iv);
        }
    }
}