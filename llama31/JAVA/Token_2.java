import java.lang.String;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Token_2_2 {
    public static boolean verifyToken(String token, String secretKey) {
        String[] parts = token.split(":");
        if (parts.length != 2) {
            return false;
        }

        String signature = parts[1];
        String expectedSignature = HmacToken.generateToken(secretKey, parts[0]);
        return signature.equals(expectedSignature);
    }

    public static void main(String[] args) {
    }
}

class HmacToken {
    public static String generateToken(String secretKey, String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] bytes = mac.doFinal(data.getBytes());
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}