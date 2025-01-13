import java.lang.String;
import java.lang.Integer;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AccountIdGenerator {
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final int NEW_ACCOUNT_ID_LENGTH = 16; // adjust to your liking

    public static String generateNewAccountId(String originalUserId, String secretKey) throws Exception {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), HMAC_ALGORITHM);
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(originalUserId.getBytes());
        byte[] newAccountIdBytes = new byte[NEW_ACCOUNT_ID_LENGTH];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(newAccountIdBytes);
        for (int i = 0; i < NEW_ACCOUNT_ID_LENGTH; i++) {
            newAccountIdBytes[i] ^= hmacBytes[i % hmacBytes.length];
        }
        return bytesToHex(newAccountIdBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

	public static void main(String[] args) {
	}
}