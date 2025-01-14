import java.lang.String;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class SecureRandomGenerator {
    SecureRandom sr;

    public SecureRandomGenerator() {
        try {
            sr = java.security.SecureRandom.getInstance("NativePRNGNonBlocking");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}