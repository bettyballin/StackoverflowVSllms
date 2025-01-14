import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecureDataProcessor {

    private static final String ALGORITHM = "AES";
    private byte[] key; // Ensure this is securely managed

    public SecureDataProcessor(byte[] encryptionKey) {
        this.key = encryptionKey;
    }

    public byte[] encryptData(byte[] dataToEncrypt) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(dataToEncrypt);
    }

    public byte[] decryptData(byte[] encryptedData) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedData);
    }

	public static void main(String[] args) {
	}
}