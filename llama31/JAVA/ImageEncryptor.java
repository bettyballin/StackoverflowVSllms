import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class ImageEncryptor {
    private static final String ALGORITHM = "AES";
    private static final String MODE = "CBC";
    private static final String PADDING = "PKCS5Padding";

    public static byte[] encrypt(byte[] imageData, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM + "/" + MODE + "/" + PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Generate a random IV (initialization vector)
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Encrypt the image data in chunks
        byte[] encryptedData = new byte[imageData.length];
        int chunkSize = 4 * 1024; // 4KB chunks
        for (int i = 0; i < imageData.length; i += chunkSize) {
            int chunkLen = Math.min(chunkSize, imageData.length - i);
            byte[] chunk = new byte[chunkLen];
            System.arraycopy(imageData, i, chunk, 0, chunkLen);
            cipher.update(chunk, 0, chunkLen, encryptedData, i);
        }

        // Return the encrypted data with the IV prepended
        byte[] result = new byte[iv.length + encryptedData.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        System.arraycopy(encryptedData, 0, result, iv.length, encryptedData.length);
        return result;
    }

	public static void main(String[] args) {
	}
}