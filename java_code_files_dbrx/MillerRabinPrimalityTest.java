import java.math.BigInteger;
import java.util.Random;
import java.security.SecureRandom;

public class MillerRabinPrimalityTest {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static boolean millerRabinTest(BigInteger n, int k){
        // Corner cases
        if (n.compareTo(BigInteger.ONE) <= 0 || n.testBit(0) == false)
            return false;
        // Check special cases of n = {2,3} manually
        else if (n.equals(BigInteger.valueOf(2)) | n.equals(BigInteger.valueOf(3)))
            return true;
        BigInteger s = n.subtract(BigInteger.ONE);
        while ((s.and(BigInteger.ONE)).compareTo(BigInteger.ZERO) == 0){ // While exponent divisible by two
            s = s.shiftRight(1);       // Divide it by 2
            k--;                    // decrement iterations
        }
        Random rnd = new SecureRandom();         // Initialize random number generator with the default seed
        for (int i = 0; i < k; i++){        // Repeat for desired confidence of accuracy
            BigInteger a = new BigInteger(n.bitLength(), rnd).mod(n.subtract(BigInteger.ONE)).add(BigInteger.ONE);      // Get Random base 'a' in range (2, n−1)
            if (!checkComposite(n, a))  // If the number is not composite then it's likely prime with certainty
                return false;           // Otherwise try another random base
        }
        return true;                   // Return probably Prime
    }

    private static boolean checkComposite(BigInteger n, BigInteger a) {
        BigInteger nMinusOne = n.subtract(BigInteger.ONE);
        BigInteger d = nMinusOne;
        int s = 0;
        // Factor out powers of 2 from n-1:
        while (d.mod(TWO).equals(BigInteger.ZERO)) {
            d = d.divide(TWO);
            s++;
        }
        BigInteger x = a.modPow(d, n);
        if (x.equals(BigInteger.ONE) || x.equals(nMinusOne))
            return false; // Probably prime
        for (int r = 0; r < s - 1; r++) {
            x = x.modPow(TWO, n);
            if (x.equals(nMinusOne))
                return false; // Probably prime
        }
        return true; // Composite
    }

    public static void main(String[] args) {
    }
}