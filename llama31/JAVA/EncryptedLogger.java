import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptedLogger {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final int KEY_SIZE = 256;
    private static final int IV_SIZE = 16;

    private SecretKeySpec key;
    private SecureRandom random;

    public EncryptedLogger(SecretKeySpec key) {
        this.key = key;
        this.random = new SecureRandom();
    }

    public void log(String message) throws Exception {
        // Generate IV
        byte[] iv = new byte[IV_SIZE];
        random.nextBytes(iv);

        // Encrypt message
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());

        // Create log entry header
        byte[] header = new byte[16]; // Increased header size to 16 bytes
        header[0] = (byte) (encryptedMessage.length >> 24); // Changed to 24 to accommodate 4 bytes for length
        header[1] = (byte) (encryptedMessage.length >> 16);
        header[2] = (byte) (encryptedMessage.length >> 8);
        header[3] = (byte) encryptedMessage.length;
        header[4] = (byte) (System.currentTimeMillis() >> 56); // Changed to 56 to accommodate 8 bytes for timestamp
        header[5] = (byte) (System.currentTimeMillis() >> 48);
        header[6] = (byte) (System.currentTimeMillis() >> 40);
        header[7] = (byte) (System.currentTimeMillis() >> 32);
        header[8] = (byte) (System.currentTimeMillis() >> 24);
        header[9] = (byte) (System.currentTimeMillis() >> 16);
        header[10] = (byte) (System.currentTimeMillis() >> 8);
        header[11] = (byte) System.currentTimeMillis();
        header[12] = (byte) (iv.length >> 8);
        header[13] = (byte) iv.length;
        header[14] = (byte) 0; // Reserved
        header[15] = (byte) 0; // Reserved

        // Append log entry to file
        FileOutputStream fos = new FileOutputStream("log.bin", true);
        fos.write(header);
        fos.write(iv);
        fos.write(encryptedMessage);
        fos.close();
    }

    public static void main(String[] args) throws Exception {
        // Generate a random key
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE);
        SecretKeySpec key = new SecretKeySpec(keyGen.generateKey().getEncoded(), ALGORITHM);

        EncryptedLogger logger = new EncryptedLogger(key);
        logger.log("User 'Bob' logged in");
        logger.log("Navigated to config page");
        logger.log("Option x changed to y");
    }
}