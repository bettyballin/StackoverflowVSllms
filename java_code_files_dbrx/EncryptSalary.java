import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EncryptSalary {
    public static void main(String[] args) throws Exception {
        String plainTextSalary = "1500"; // salary value retrieved from database

        // Generate the encryption key using a secure derivation function
        // such as PBKDF2, with enough salt and iteration count
        SecretKey secretKey = generateKey();

        // Generate a random Initialization Vector (IV)
        byte[] iv = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        // Encrypt the salary
        byte[] encryptedSalary = encryptStringToBytes_Aes(plainTextSalary, secretKey, ivParameterSpec);

        // You can then store this 'encryptedSalary' in the database instead of plain text values
        // For demonstration, print the Base64 encoded encryptedSalary
        System.out.println("Encrypted Salary: " + Base64.getEncoder().encodeToString(encryptedSalary));
    }

    private static SecretKey generateKey() throws Exception {
        // Use a password-based key derivation function (PBKDF2) with a secure password and salt
        String password = "securePassword"; // In a real application, obtain this securely
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt); // Generate a random salt

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256); // 65536 iterations and 256-bit key
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();

        // Create a SecretKey from the byte array
        return new SecretKeySpec(keyBytes, "AES");
    }

    private static byte[] encryptStringToBytes_Aes(String plainText, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception {
        // Create a Cipher instance for AES encryption in CBC mode with PKCS5 padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Initialize the cipher with the secret key and IV
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        // Encrypt the plain text and return the byte array
        return cipher.doFinal(plainText.getBytes("UTF-8"));
    }
}