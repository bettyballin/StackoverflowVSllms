/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 */
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthTokenValidator {
    private static final String secretKey = "your_secret_key_here";

    public boolean validateAuthToken(HttpServletRequest httpServletRequest) {
        Cookie[] cookieArray = httpServletRequest.getCookies();
        Cookie cookie = null;
        if (cookieArray != null) {
            for (Cookie cookie2 : cookieArray) {
                if (!cookie2.getName().equals("authToken")) continue;
                cookie = cookie2;
                break;
            }
        }
        if (cookie != null && cookie.getValue() != null) {
            String string;
            String string2;
            String string3 = cookie.getValue();
            if (string3.equals(string2 = this.hmacSha256(string = httpServletRequest.getSession().getId(), secretKey))) {
                Cookie cookie2;
                cookie2 = httpServletRequest.getSession();
                return cookie2.getAttribute("userId") != null;
            }
            return false;
        }
        return false;
    }

    private String hmacSha256(String string, String string2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] byArray = mac.doFinal(string.getBytes(StandardCharsets.UTF_8));
            return this.bytesToHex(byArray);
        }
        catch (InvalidKeyException | NoSuchAlgorithmException generalSecurityException) {
            throw new RuntimeException(generalSecurityException);
        }
    }

    private String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
