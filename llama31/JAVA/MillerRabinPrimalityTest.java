import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabinPrimalityTest {
    private static final int DEFAULT_ITERATIONS = 5;

    public static boolean isProbablePrime(BigInteger n, int iterations) {
        if (n.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        if (n.compareTo(BigInteger.valueOf(2)) == 0 || n.compareTo(BigInteger.valueOf(3)) == 0) {
            return true;
        }
        if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
            return false;
        }

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < iterations; i++) {
            BigInteger a = uniformRandom(n.subtract(BigInteger.ONE), random);
            if (witness(a, n)) {
                return false;
            }
        }
        return true;
    }

    private static BigInteger uniformRandom(BigInteger max, SecureRandom random) {
        BigInteger rand;
        do {
            rand = new BigInteger(max.bitLength(), random);
        } while (rand.compareTo(max) >= 0);
        return rand;
    }

    private static boolean witness(BigInteger a, BigInteger n) {
        BigInteger u = n.subtract(BigInteger.ONE);
        int t = 0;
        while (u.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
            u = u.divide(BigInteger.valueOf(2));
            t++;
        }

        BigInteger x = a.modPow(u, n);
        if (x.compareTo(BigInteger.ONE) == 0 || x.compareTo(n.subtract(BigInteger.ONE)) == 0) {
            return false;
        }

        for (int i = 0; i < t - 1; i++) {
            x = x.modPow(BigInteger.valueOf(2), n);
            if (x.compareTo(n.subtract(BigInteger.ONE)) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test the isProbablePrime method
        BigInteger n = BigInteger.valueOf(23);
        int iterations = DEFAULT_ITERATIONS;
        System.out.println(n + " is probable prime: " + isProbablePrime(n, iterations));
    }
}