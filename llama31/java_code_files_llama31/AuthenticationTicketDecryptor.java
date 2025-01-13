/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 */
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationTicketDecryptor {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public void decryptAuthenticationTicket(HttpServletRequest httpServletRequest) throws Exception {
        String string = "FormsAuthentication.FormsCookieName";
        Cookie cookie = this.getCookie(httpServletRequest, string);
        if (cookie != null) {
            String string2 = cookie.getValue();
            String string3 = this.decrypt(string2, "your_secret_key");
            System.out.println("Decrypted Value: " + string3);
        } else {
            System.out.println("Cookie not found.");
        }
    }

    private Cookie getCookie(HttpServletRequest httpServletRequest, String string) {
        Cookie[] cookieArray = httpServletRequest.getCookies();
        if (cookieArray != null) {
            for (Cookie cookie : cookieArray) {
                if (!cookie.getName().equals(string)) continue;
                return cookie;
            }
        }
        return null;
    }

    private String decrypt(String string, String string2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        byte[] byArray = Base64.getDecoder().decode(string);
        byte[] byArray2 = cipher.doFinal(byArray);
        return new String(byArray2);
    }
}
