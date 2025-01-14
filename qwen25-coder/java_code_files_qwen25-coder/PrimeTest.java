import java.lang.String;
import java.math.BigInteger;
import java.util.Random;

public class PrimeTest {
    public static void main(String[] args) {
        // Example: Generating a 1000-digit number (for demonstration, use your number instead)
        BigInteger bigInt = new BigInteger(1000 * 4 / 3, new Random()); // Approximate 1000 digits
        System.out.println("Is the number prime? " + isPrime(bigInt));
    }

    public static boolean isPrime(BigInteger n) {
        // Handle small numbers directly
        if (n.compareTo(BigInteger.TWO) < 0)
            return false;
        if (n.equals(BigInteger.TWO))
            return true;
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            return false;

        // Use Miller-Rabin test for large numbers (probabilistic, but very accurate)
        int certainty = 128; // Higher means more accuracy
        return n.isProbablePrime(certainty);
    }
}