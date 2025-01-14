import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class ProtocolEncryption {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private SecretKey secretKey;
    private IvParameterSpec ivSpec;

    public ProtocolEncryption() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        secretKey = keyGen.generateKey();
        byte[] iv = new byte[16];
        // SecureRandom random = new SecureRandom();
        // random.nextBytes(iv); - Initialize IV securely
        ivSpec = new IvParameterSpec(iv);
    }

    public byte[] encrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(data);
    }

    public byte[] decrypt(byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(encryptedData);
    }

	public static void main(String[] args) {
	}
}