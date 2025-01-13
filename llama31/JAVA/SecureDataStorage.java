import java.lang.String;
import java.util.Base64;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

// Use a secure password hashing algorithm like bcrypt or PBKDF2
import org.mindrot.jbcrypt.BCrypt;

// Store sensitive data encrypted

public class SecureDataStorage {
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static String encryptData(String data, String encryptionKey) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        String password = "mysecretpassword";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        String dataToEncrypt = "This is some sensitive data";
        String encryptionKey = "mysecretkey12345";
        String encryptedData = encryptData(dataToEncrypt, encryptionKey);
        System.out.println("Encrypted Data: " + encryptedData);
    }
}