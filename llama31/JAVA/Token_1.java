import java.lang.String;
import java.time.Instant;

public class Token_1_1 {
    public static String generateToken() {
        long timestamp = Instant.now().getEpochSecond();
        String secretKey = "this is a secret key";
        String signature = HmacToken.generateToken(secretKey, Long.toString(timestamp));
        return timestamp + ":" + signature;
    }

    public static void main(String[] args) {
        System.out.println(generateToken());
    }
}

class HmacToken {
    public static String generateToken(String secretKey, String timestamp) {
        // Implementation of HmacToken.generateToken() method is missing in the original code.
        // For demonstration purposes, a simple implementation using Java's built-in HMAC function is provided.
        javax.crypto.Mac mac;
        try {
            mac = javax.crypto.Mac.getInstance("HmacSHA256");
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] digest = mac.doFinal(timestamp.getBytes());
            java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
            return encoder.encodeToString(digest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}