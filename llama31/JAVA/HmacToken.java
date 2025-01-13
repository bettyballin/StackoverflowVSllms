import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

public class HmacToken {
    public static String generateToken(String secretKey, String value) {
        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            sha256Hmac.init(key);
            byte[] mac = sha256Hmac.doFinal(value.getBytes("UTF-8"));
            return new String(Base64.getEncoder().encode(mac), "UTF-8");
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String secretKey = "your_secret_key";
        String value = "your_value";
        String token = generateToken(secretKey, value);
        System.out.println(token);
    }
}