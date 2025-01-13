import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthenticator {

    // Assuming these are defined somewhere
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String secretKey;
    private String userId;

    public void authenticate() {
        // Create a session and store the user's ID
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);

        // Create a secure token (hashed and signed session ID)
        String sessionId = session.getId();
        String token = hmacSha256(sessionId, secretKey);

        // Set the secure cookie
        Cookie cookie = new Cookie("authToken", token);
        cookie.setSecure(true); // Only transmit over HTTPS
        cookie.setHttpOnly(true); // Prevent JavaScript access
        response.addCookie(cookie);
    }

    private String hmacSha256(String data, String secretKey) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] bytes = mac.doFinal(data.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // You would need to initialize the request, response, secretKey, and userId here
        // and call the authenticate method
    }
}