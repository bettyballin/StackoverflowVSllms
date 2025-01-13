/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigInteger;
import java.util.Random;

public class PrimeTest {
    public static void main(String[] stringArray) {
        String string = "your_1000_digit_number_here";
        BigInteger bigInteger = new BigInteger(string);
        int n = 5;
        Random random = new Random();
        boolean bl = true;
        for (int i = 0; i < n; ++i) {
            BigInteger bigInteger2 = PrimeTest.uniformRandom(bigInteger, random);
            if (PrimeTest.millerRabin(bigInteger, bigInteger2)) continue;
            bl = false;
            break;
        }
        System.out.println(bl ? "Prime" : "Composite");
    }

    private static BigInteger uniformRandom(BigInteger bigInteger, Random random) {
        BigInteger bigInteger2;
        while ((bigInteger2 = new BigInteger(bigInteger.bitLength(), random)).compareTo(bigInteger) >= 0) {
        }
        return bigInteger2;
    }

    private static boolean millerRabin(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger.equals(BigInteger.ONE) || bigInteger.equals(BigInteger.ZERO)) {
            return true;
        }
        if (bigInteger.mod(BigInteger.valueOf(2L)).equals(BigInteger.ZERO)) {
            return false;
        }
        int n = 0;
        BigInteger bigInteger3 = bigInteger.subtract(BigInteger.ONE);
        while (bigInteger3.mod(BigInteger.valueOf(2L)).equals(BigInteger.ZERO)) {
            ++n;
            bigInteger3 = bigInteger3.divide(BigInteger.valueOf(2L));
        }
        BigInteger bigInteger4 = bigInteger2.modPow(bigInteger3, bigInteger);
        if (bigInteger4.equals(BigInteger.ONE) || bigInteger4.equals(bigInteger.subtract(BigInteger.ONE))) {
            return true;
        }
        for (int i = 0; i < n - 1; ++i) {
            if (!(bigInteger4 = bigInteger4.modPow(BigInteger.valueOf(2L), bigInteger)).equals(bigInteger.subtract(BigInteger.ONE))) continue;
            return true;
        }
        return false;
    }
}
