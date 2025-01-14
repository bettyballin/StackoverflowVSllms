import java.lang.String;
// Example of HMAC generation in Java
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec; 
import java.util.Base64;

public class HmacExample {
    public static void main(String[] args) throws Exception {
        String data = "request-data";
        String key = "your-secret-key";
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] hash = sha256_HMAC.doFinal(data.getBytes());
        String hmacBase64 = Base64.getEncoder().encodeToString(hash);
        System.out.println("HMAC SHA-256: " + hmacBase64);
    }
}