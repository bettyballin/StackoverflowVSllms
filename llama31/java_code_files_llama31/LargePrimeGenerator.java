/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigInteger;
import java.security.SecureRandom;

public class LargePrimeGenerator {
    private static final int DEFAULT_ITERATIONS = 5;

    public static BigInteger generateLargePrime(int n) {
        BigInteger bigInteger;
        SecureRandom secureRandom = new SecureRandom();
        while (!(bigInteger = new BigInteger(n, secureRandom)).isProbablePrime(5)) {
        }
        return bigInteger;
    }

    public static void main(String[] stringArray) {
        BigInteger bigInteger = LargePrimeGenerator.generateLargePrime(2048);
        System.out.println(bigInteger);
    }
}
