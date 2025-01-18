import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BigInteger p = BigInteger.probablePrime(16, new Random()); // find other 'safe' large primes from the internet and use those in place of this one as needed...

        BigInteger e = BigInteger.valueOf(0x12_c7b3L).multiply(new BigInteger("980745139286", 16)).mod(p); // Use a different fixed point from above and a secret hash-based value you generate, or another large input value that meets your criteria here

        BigInteger publicKey = BigInteger.valueOf(65537); // Initialize publicKey appropriately

        while (true) // make sure our product stays below your maximum value limit and is never less than zero...
        { 
            e = e.multiply(BigInteger.valueOf(6_700_417));

            if (e.compareTo(BigInteger.ONE.shiftLeft(39)) <= 0
                || (e.modPow(publicKey, p)).compareTo(BigInteger.ZERO) > 0)
                break;
        }
        // format preserving number formatting goes here. See below for more detail on this part…
    }
}