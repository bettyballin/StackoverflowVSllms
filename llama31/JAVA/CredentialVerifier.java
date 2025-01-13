import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Assuming CredentialSigner is another class with a static method signCredentials
class CredentialSigner {
    public static String signCredentials(String credentials) {
        // Implementation of signing credentials
        return "";
    }
}

public class CredentialVerifier {
    public static boolean verifyCredentials(String receivedCredentials, String expectedSignature) throws NoSuchAlgorithmException, InvalidKeyException {
        String computedSignature = CredentialSigner.signCredentials(receivedCredentials);
        return MessageDigest.isEqual(computedSignature.getBytes(), expectedSignature.getBytes());
    }

    public static void main(String[] args) {
    }
}