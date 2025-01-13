import java.lang.String;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TokenSigner {
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final byte[] SECRET_KEY = "my_secret_key".getBytes();

    public static String signToken(String token) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(new SecretKeySpec(SECRET_KEY, HMAC_ALGORITHM));
        byte[] signature = mac.doFinal(token.getBytes());
        return bytesToHex(signature);
    }

    public static boolean verifyToken(String token, String signature) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(new SecretKeySpec(SECRET_KEY, HMAC_ALGORITHM));
        byte[] expectedSignature = mac.doFinal(token.getBytes());
        return constantTimeEquals(expectedSignature, hexToBytes(signature));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    private static boolean constantTimeEquals(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];
        }
        return result == 0;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String token = "Hello, World!";
        String signature = signToken(token);
        System.out.println("Token: " + token);
        System.out.println("Signature: " + signature);
        boolean verified = verifyToken(token, signature);
        System.out.println("Verified: " + verified);
    }
}