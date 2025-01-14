import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.nio.file.Files;
import java.security.SecureRandom;

public class SecureLogger {
    private SecretKey secretKey;
    private File logFile;

    public SecureLogger(String filePath) throws Exception {
        // Load or generate the secret key securely
        secretKey = KeyGenerator.getInstance("AES").generateKey();
        logFile = new File(filePath);
    }

    public void log(String entry) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[cipher.getBlockSize()];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpecs = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpecs);
        byte[] encryptedText = cipher.doFinal(entry.getBytes());

        try (FileOutputStream out = new FileOutputStream(logFile, true)) {
            // Write IV and then encrypted text
            out.write(iv);
            out.write(encryptedText);
        }
    }

    public void readLogs() throws Exception {
        Cipher decipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        try (DataInputStream in = new DataInputStream(new FileInputStream(logFile))) {
            while (in.available() >= 24) { // Ensure enough bytes for IV and encrypted log entry
                byte[] iv = in.readNBytes(16); // Adjust according to the block size
                IvParameterSpec ivSpecs = new IvParameterSpec(iv);
                decipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpecs);

                byte[] sizeBytes = in.readNBytes(4);
                int entrySize = ((sizeBytes[0] & 0xFF) << 24) |
                                ((sizeBytes[1] & 0xFF) << 16) |
                                ((sizeBytes[2] & 0xFF) << 8)  |
                                 (sizeBytes[3] & 0xFF);
                byte[] encryptedData = in.readNBytes(entrySize);

                String decryptedEntry = new String(decipher.doFinal(encryptedData));
                System.out.println("Decrypted Entry: " + decryptedEntry);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SecureLogger logger = new SecureLogger("user_activities.enc");
        logger.log("12/03/2009 08:34:21 -> User 'Bob' logged in");
        logger.log("12/03/2009 08:34:28 -> Navigated to config page");

        // Reading back the logs
        logger.readLogs();
    }
}