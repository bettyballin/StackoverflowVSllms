import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class SecureStorage {

    private static final String ALGORITHM = "AES";

    private static Key getKey() throws Exception {
        // Generate or retrieve the key
        // For demonstration, we generate a new key each time (not secure in practice)
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(256); // AES-256
        return keyGen.generateKey();
    }

    public static void savePassword(String password) {
        try {
            Key key = getKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(password.getBytes());

            // Save the encrypted password to a file
            try (FileOutputStream fos = new FileOutputStream("password.enc")) {
                fos.write(encrypted);
            }

            // Save the key securely (for demonstration, we save it to a file)
            try (FileOutputStream fos = new FileOutputStream("key.enc")) {
                fos.write(key.getEncoded());
            }
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPassword() {
        try {
            // Read the key from the file
            byte[] keyBytes = new byte[32]; // 256 bits for AES-256
            try (FileInputStream fis = new FileInputStream("key.enc")) {
                fis.read(keyBytes);
            }
            Key key = new SecretKeySpec(keyBytes, ALGORITHM);

            // Read the encrypted password from the file
            byte[] encrypted;
            try (FileInputStream fis = new FileInputStream("password.enc")) {
                encrypted = fis.readAllBytes();
            }

            // Decrypt the password
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(encrypted);

            return new String(decrypted);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        savePassword("mySecurePassword");
        String password = getPassword();
        System.out.println("Retrieved password: " + password);
    }
}