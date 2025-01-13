/*
 * Decompiled with CFR 0.152.
 */
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacToken {
    public static String generateToken(String string, String string2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(string.getBytes("UTF-8"), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] byArray = mac.doFinal(string2.getBytes("UTF-8"));
            return new String(Base64.getEncoder().encode(byArray), "UTF-8");
        }
        catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void main(String[] stringArray) {
        String string = "your_secret_key";
        String string2 = "your_value";
        String string3 = HmacToken.generateToken(string, string2);
        System.out.println(string3);
    }
}
