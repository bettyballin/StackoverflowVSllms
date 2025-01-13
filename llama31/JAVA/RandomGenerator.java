import java.security.SecureRandom;

public class RandomGenerator {
    SecureRandom secureRandom;

    public RandomGenerator() throws Exception {
        secureRandom = SecureRandom.getInstance("SHA1PRNG");
    }

    public static void main(String[] args) throws Exception {
        new RandomGenerator();
    }
}