import java.lang.String;
import java.math.BigInteger;
import java.util.Random;

public class PrimeTest {
    public static void main(String[] args) {
        String input = "your_1000_digit_number_here";
        BigInteger n = new BigInteger(input);

        int iterations = 5; // number of iterations to run the test
        Random rand = new Random();

        boolean isPrime = true;
        for (int i = 0; i < iterations; i++) {
            BigInteger a = uniformRandom(n, rand);
            if (!millerRabin(n, a)) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime ? "Prime" : "Composite");
    }

    private static BigInteger uniformRandom(BigInteger n, Random rand) {
        BigInteger r;
        do {
            r = new BigInteger(n.bitLength(), rand);
        } while (r.compareTo(n) >= 0);
        return r;
    }

    private static boolean millerRabin(BigInteger n, BigInteger a) {
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) {
            return true; // 0 and 1 are not prime
        }

        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            return false; // even numbers > 2 are not prime
        }

        // find r and s such that n-1 = 2^r * s
        int r = 0;
        BigInteger s = n.subtract(BigInteger.ONE);
        while (s.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            r++;
            s = s.divide(BigInteger.valueOf(2));
        }

        // compute a^s % n
        BigInteger x = a.modPow(s, n);

        if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))) {
            return true; // a is a witness for n
        }

        for (int i = 0; i < r - 1; i++) {
            x = x.modPow(BigInteger.valueOf(2), n);
            if (x.equals(n.subtract(BigInteger.ONE))) {
                return true; // a is a witness for n
            }
        }

        return false; // a is not a witness for n
    }
}