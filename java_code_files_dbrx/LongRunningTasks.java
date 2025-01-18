import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;

public class LongRunningTasks {
    public void triggerKeyGeneration(int iterations) {
        try {
            long start = System.currentTimeMillis();
            for (int i = 0; i < iterations; i++) {
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
                keyGen.initialize(1024, random);
                keyGen.generateKeyPair();
            }
            System.out.println("triggerKeyGeneration: " + (System.currentTimeMillis() - start));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    private static final Random random = new Random();
    private static final BigInteger veryBig = new BigInteger(1200, random);

    public BigInteger findNextProbablePrime() {
        return veryBig.nextProbablePrime();
    }

    public String calculatePiDigits(int digits) {
        StringBuilder pi = new StringBuilder("3");
        if (digits > 0) {
            pi.append(".");
            int[] x = new int[digits * 10 / 3 + 2];
            int[] r = new int[digits * 10 / 3 + 2];
            for (int i = 0; i < x.length; i++)
                x[i] = 20;
            for (int i = 0; i < digits; i++) {
                int carry = 0;
                for (int j = x.length - 1; j > 0; j--) {
                    int numerator = x[j] * 10 + carry;
                    int denominator = 2 * j + 1;
                    x[j] = numerator % denominator;
                    carry = numerator / denominator * j;
                }
                pi.append(carry / 10);
            }
        }
        return pi.toString();
    }

    public static void main(String[] args) {
    }
}