import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.SecureRandom;

public class PasswordProtectedFile {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final int ITERATIONS = 10000;

    public static byte[] encrypt(byte[] data, String password) throws Exception {
        // Generate a random salt value
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        // Derive the symmetric key
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey key = factory.generateSecret(spec);

        // Encrypt the data
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data);

        // Store the salt value alongside the encrypted data
        byte[] output = new byte[salt.length + encryptedData.length];
        System.arraycopy(salt, 0, output, 0, salt.length);
        System.arraycopy(encryptedData, 0, output, salt.length, encryptedData.length);

        return output;
    }

    public static byte[] decrypt(byte[] encryptedData, String password) throws Exception {
        // Extract the salt value from the encrypted data
        byte[] salt = new byte[16];
        System.arraycopy(encryptedData, 0, salt, 0, salt.length);

        // Derive the symmetric key
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey key = factory.generateSecret(spec);

        // Decrypt the data
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(encryptedData, salt.length, encryptedData.length - salt.length);

        return decryptedData;
    }

	public static void main(String[] args) {
	}
}