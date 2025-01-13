import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AuthenticationTicketDecryptor {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public void decryptAuthenticationTicket(HttpServletRequest request) throws Exception {
        String cookieName = "FormsAuthentication.FormsCookieName"; // Replace with your actual cookie name
        Cookie cookie = getCookie(request, cookieName);
        if (cookie != null) {
            String encryptedValue = cookie.getValue();
            String decryptedValue = decrypt(encryptedValue, "your_secret_key"); // Replace with your actual secret key
            // Process the decrypted authentication ticket value
            System.out.println("Decrypted Value: " + decryptedValue);
        } else {
            System.out.println("Cookie not found.");
        }
    }

    private Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    private String decrypt(String encryptedValue, String secretKey) throws Exception {
        Key key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedValue);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
}