import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class SecureRandomInitializer {
    SecureRandom sr = new SecureRandom();

    {
        try {
            sr.setSeed(java.security.SecureRandom.getInstance("NativePRNGNonBlocking").generateSeed(16));
        } catch (NoSuchAlgorithmException e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
    }
}