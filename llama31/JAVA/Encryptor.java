import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
    public static String encrypt(String data, String key) throws Exception {
        // Create a new AES cipher instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Initialize the cipher with the key and IV
        byte[] ivBytes = new byte[16];
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        // Encrypt the data
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());

        // Base64-encode the encrypted bytes
        String encryptedBase64 = java.util.Base64.getEncoder().encodeToString(encryptedBytes);

        return encryptedBase64;
    }

	public static void main(String[] args) {
	}
}