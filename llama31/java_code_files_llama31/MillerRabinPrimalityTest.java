/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabinPrimalityTest {
    private static final int DEFAULT_ITERATIONS = 5;

    public static boolean isProbablePrime(BigInteger bigInteger, int n) {
        if (bigInteger.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        if (bigInteger.compareTo(BigInteger.valueOf(2L)) == 0 || bigInteger.compareTo(BigInteger.valueOf(3L)) == 0) {
            return true;
        }
        if (bigInteger.mod(BigInteger.valueOf(2L)).compareTo(BigInteger.ZERO) == 0) {
            return false;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < n; ++i) {
            BigInteger bigInteger2 = MillerRabinPrimalityTest.uniformRandom(bigInteger.subtract(BigInteger.ONE), secureRandom);
            if (!MillerRabinPrimalityTest.witness(bigInteger2, bigInteger)) continue;
            return false;
        }
        return true;
    }

    private static BigInteger uniformRandom(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2;
        while ((bigInteger2 = new BigInteger(bigInteger.bitLength(), secureRandom)).compareTo(bigInteger) >= 0) {
        }
        return bigInteger2;
    }

    private static boolean witness(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = bigInteger2.subtract(BigInteger.ONE);
        int n = 0;
        while (bigInteger3.mod(BigInteger.valueOf(2L)).compareTo(BigInteger.ZERO) == 0) {
            bigInteger3 = bigInteger3.divide(BigInteger.valueOf(2L));
            ++n;
        }
        BigInteger bigInteger4 = bigInteger.modPow(bigInteger3, bigInteger2);
        if (bigInteger4.compareTo(BigInteger.ONE) == 0 || bigInteger4.compareTo(bigInteger2.subtract(BigInteger.ONE)) == 0) {
            return false;
        }
        for (int i = 0; i < n - 1; ++i) {
            if ((bigInteger4 = bigInteger4.modPow(BigInteger.valueOf(2L), bigInteger2)).compareTo(bigInteger2.subtract(BigInteger.ONE)) != 0) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] stringArray) {
        BigInteger bigInteger = BigInteger.valueOf(23L);
        int n = 5;
        System.out.println(String.valueOf(bigInteger) + " is probable prime: " + MillerRabinPrimalityTest.isProbablePrime(bigInteger, n));
    }
}
