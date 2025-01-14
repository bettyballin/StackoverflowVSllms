// Encryption utility class
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final SecretKeySpec secretKey;

    static {
        byte[] key = Base64.getDecoder().decode("your-encrypted-key-here");
        secretKey = new SecretKeySpec(key, ALGORITHM);
    }

    public static String encrypt(String valueToEnc) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(valueToEnc.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

	public static void main(String[] args) {
	}
}