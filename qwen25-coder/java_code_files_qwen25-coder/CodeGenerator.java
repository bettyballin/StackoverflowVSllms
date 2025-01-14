import java.lang.String;
import java.lang.Integer;
// Example simplified code snippet in Java

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CodeGenerator {
    private static final String HMAC_SHA256_ALGORITHM = "HMACSHA256";

    public static String generateResponseCode(String productKey, String token) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(productKey.getBytes(), HMAC_SHA256_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        mac.init(keySpec);

        byte[] hashBytes = mac.doFinal(token.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        // Truncate to a shorter, more SMS-friendly version (e.g., first 6 characters)
        return hexString.substring(0, 6).toUpperCase();
    }

    public static void main(String[] args) {
        try {
            String productKey = "PRODUCTKEY123";
            String token = "123456"; // A value like a TOTP
            String responseCode = generateResponseCode(productKey, token);
            System.out.println("Generated Response Code: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}