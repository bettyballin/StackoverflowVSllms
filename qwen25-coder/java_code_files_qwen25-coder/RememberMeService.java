import java.lang.String;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class RememberMeService {

    private static final SecureRandom random = new SecureRandom();
    private static final String ENCRYPTION_KEY = "yourStrongEncryptionKey"; // Replace with a secure key
    private static final int TOKEN_LENGTH = 32; // Example length

    public Cookie generateRememberMeToken(String userId) {
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        random.nextBytes(tokenBytes);
        String token = Base64.getEncoder().encodeToString(tokenBytes);

        // Store the association of the token to userId and an expiration time in a secure store (e.g., database)

        Cookie cookie = new Cookie("rememberMe", encryptToken(token));
        cookie.setHttpOnly(true);
        cookie.setMaxAge(120 * 24 * 60 * 60); // 120 days
        cookie.setSecure(true);

        return cookie;
    }

    private String encryptToken(String token) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(token.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to encrypt token", e);
        }
    }

    // Similarly implement a method to decrypt and validate tokens

    public static void main(String[] args) {
    }
}