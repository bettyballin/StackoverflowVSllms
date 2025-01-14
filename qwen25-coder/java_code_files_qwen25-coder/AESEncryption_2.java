import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryption_2 {
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    public String encrypt(String valueToEnc) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(keyValue, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(valueToEnc.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

	public static void main(String[] args) {
	}
}