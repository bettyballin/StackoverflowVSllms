import java.lang.String;
import javax.crypto.Cipher;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import javax.crypto.spec.SecretKeySpec;

public class SecureUtil {

    private static final String KEYSTORE_PATH = "keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourKeystorePassword"; // store this securely
    private static final String KEY_ALIAS = "mySecretKey";

    public static SecretKeySpec getSecretKey() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        keyStore.load(Files.newInputStream(Paths.get(KEYSTORE_PATH)), KEYSTORE_PASSWORD.toCharArray());
        return (SecretKeySpec) keyStore.getKey(KEY_ALIAS, KEYSTORE_PASSWORD.toCharArray());
    }

    public static String encrypt(String data) throws Exception {
        SecretKeySpec secretKey = getSecretKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return java.util.Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec secretKey = getSecretKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedValue = java.util.Base64.getDecoder().decode(encryptedData.getBytes());
        byte[] decryptedBytes = cipher.doFinal(decodedValue);
        return new String(decryptedBytes);
    }

	public static void main(String[] args) {
	}
}