import java.security.SecureRandom;
import java.util.Base64;

public class RandomSaltGenerator {

    SecureRandom random = new SecureRandom();
    byte[] bytes = new byte[16];
    String saltString;

    public RandomSaltGenerator() {
        random.nextBytes(bytes); // generates a strong cryptographic seed and fills the byte array with random values
        saltString = Base64.getEncoder().encodeToString(bytes);
    }

    public static void main(String[] args) {
    }
}