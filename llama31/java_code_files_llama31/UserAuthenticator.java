/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthenticator {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String secretKey;
    private String userId;

    public void authenticate() {
        HttpSession httpSession = this.request.getSession();
        httpSession.setAttribute("userId", (Object)this.userId);
        String string = httpSession.getId();
        String string2 = this.hmacSha256(string, this.secretKey);
        Cookie cookie = new Cookie("authToken", string2);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        this.response.addCookie(cookie);
    }

    private String hmacSha256(String string, String string2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] byArray = mac.doFinal(string.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte by : byArray) {
                stringBuilder.append(String.format("%02x", by));
            }
            return stringBuilder.toString();
        }
        catch (InvalidKeyException | NoSuchAlgorithmException generalSecurityException) {
            throw new RuntimeException(generalSecurityException);
        }
    }

    public static void main(String[] stringArray) {
    }
}
