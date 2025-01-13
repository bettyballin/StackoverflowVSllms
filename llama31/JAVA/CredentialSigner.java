import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CredentialSigner {
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final SecretKeySpec secretKeySpec;

    static {
        // Initialize the secret key spec with a randomly generated key
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretKeyBytes = new byte[32];
        secureRandom.nextBytes(secretKeyBytes);
        secretKeySpec = new SecretKeySpec(secretKeyBytes, HMAC_ALGORITHM);
    }

    public static String signCredentials(String credentials) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(secretKeySpec);
        byte[] signatureBytes = mac.doFinal(credentials.getBytes());
        return Base64.getUrlEncoder().withoutPadding().encodeToString(signatureBytes);
    }

    public static void main(String[] args) {
        try {
            String credentials = "example-credentials";
            String signature = signCredentials(credentials);
            System.out.println("Signature: " + signature);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            System.err.println("Error signing credentials: " + e.getMessage());
        }
    }
}