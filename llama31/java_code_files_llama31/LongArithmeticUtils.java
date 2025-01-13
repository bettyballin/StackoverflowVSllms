/*
 * Decompiled with CFR 0.152.
 */
public class LongArithmeticUtils {
    public long addLong(long l, long l2) {
        int n = (int)(l >>> 32);
        int n2 = (int)l;
        int n3 = (int)(l2 >>> 32);
        int n4 = (int)l2;
        int n5 = n2 + n4;
        int n6 = n + n3 + (n5 >>> 31);
        return (long)n6 << 32 | (long)n5;
    }

    public static void main(String[] stringArray) {
        LongArithmeticUtils longArithmeticUtils = new LongArithmeticUtils();
        long l = longArithmeticUtils.addLong(1000000000L, 2000000000L);
        System.out.println("Result: " + l);
    }
}
