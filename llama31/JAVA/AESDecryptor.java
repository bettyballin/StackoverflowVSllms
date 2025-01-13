import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AESDecryptor {
    public static byte[] decrypt(byte[] encryptedData, byte[] key, byte[] iv) throws Exception {
        // Create a SecretKeySpec from the key
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        // Create a Cipher instance with the specified mode and padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Initialize the Cipher with the IV and secret key
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));

        // Decrypt the data
        return cipher.doFinal(encryptedData);
    }

	public static void main(String[] args) {
	}
}