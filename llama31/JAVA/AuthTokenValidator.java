import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class AuthTokenValidator {
    private static final String secretKey = "your_secret_key_here"; // Replace with your secret key

    public boolean validateAuthToken(HttpServletRequest request) {
        // Get the cookie and verify its format
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("authToken")) {
                    cookie = c;
                    break;
                }
            }
        }

        if (cookie != null && cookie.getValue() != null) {
            String token = cookie.getValue();

            // Verify the token
            String sessionId = request.getSession().getId();
            String expectedToken = hmacSha256(sessionId, secretKey);
            if (token.equals(expectedToken)) {
                // Token is valid, retrieve the associated session
                HttpSession session = request.getSession();
                // Verify the session contents (e.g., user ID)
                if (session.getAttribute("userId") != null) {
                    // User is authenticated, proceed with the request
                    return true;
                } else {
                    // Session is invalid or expired, redirect to login
                    return false;
                }
            } else {
                // Token is invalid, redirect to login
                return false;
            }
        } else {
            // Cookie is missing or malformed, redirect to login
            return false;
        }
    }

    private String hmacSha256(String input, String secretKey) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] result = mac.doFinal(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(result);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // You need an HttpServletRequest object to use the validateAuthToken method.
        // This is usually obtained from a Java Servlet.
        // For a console application, you would need to mock this object or create a different method.
    }
}