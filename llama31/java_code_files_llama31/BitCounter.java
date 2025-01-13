/*
 * Decompiled with CFR 0.152.
 */
public class BitCounter {
    int countSetBits(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] stringArray) {
        BitCounter bitCounter = new BitCounter();
        System.out.println(bitCounter.countSetBits(10));
    }
}
