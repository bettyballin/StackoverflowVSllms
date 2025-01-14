import java.lang.String;
// Example of setting an encrypted cookie in Java using AES encryption
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;

public class CookieEncryptionUtil {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY_VALUE = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e' ,'c', 'r', 'e', 't', 'K', 'e', 'y'};
    
    public static String encrypt(String value) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY_VALUE, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedValue = cipher.doFinal(value.getBytes());
        return java.util.Base64.getEncoder().encodeToString(encryptedValue);
    }
    
    public static String decrypt(String value) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY_VALUE, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedValue = java.util.Base64.getDecoder().decode(value);
        byte[] decryptedValue = cipher.doFinal(decodedValue);
        return new String(decryptedValue);
    }
    
    public static Cookie createEncryptedCookie(String name, String value) throws Exception {
        String encryptedValue = encrypt(value);
        Cookie cookie = new Cookie(name, encryptedValue);
        cookie.setHttpOnly(true); // Protects against XSS attacks
        cookie.setSecure(true);  // Ensures the cookie is sent only over HTTPS
        return cookie;
    }

	public static void main(String[] args) {
	}
}