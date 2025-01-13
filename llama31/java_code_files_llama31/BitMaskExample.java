/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigInteger;

public class BitMaskExample {
    public static void main(String[] stringArray) {
        BigInteger bigInteger = BigInteger.valueOf(2L).pow(128);
        BigInteger bigInteger2 = BigInteger.valueOf(2L).pow(64);
        System.out.println(bigInteger.and(bigInteger2));
        System.out.println(bigInteger.or(bigInteger2));
        System.out.println(bigInteger.xor(bigInteger2));
    }
}
