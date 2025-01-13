import java.math.BigInteger;
import java.security.SecureRandom;

public class LargePrimeGenerator {
    private static final int DEFAULT_ITERATIONS = 5;

    public static BigInteger generateLargePrime(int bitLength) {
        SecureRandom random = new SecureRandom();
        while (true) {
            BigInteger primeCandidate = new BigInteger(bitLength, random);
            if (primeCandidate.isProbablePrime(DEFAULT_ITERATIONS)) {
                return primeCandidate;
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        BigInteger largePrime = generateLargePrime(2048);
        System.out.println(largePrime);
    }
}