/*
 * Decompiled with CFR 0.152.
 */
public class BitVectorHashCalculator {
    public static int sparseBitVectorHash(long[] lArray, int n) {
        int n2 = n;
        for (long l : lArray) {
            n2 = n2 * -2016183407 ^ Long.hashCode(l);
        }
        return n2 & 0xFFFFFFFF;
    }

    public static void main(String[] stringArray) {
        long[] lArray = new long[]{1L, 2L, 3L};
        int n = 123;
        int n2 = BitVectorHashCalculator.sparseBitVectorHash(lArray, n);
        System.out.println("Hash: " + n2);
    }
}
