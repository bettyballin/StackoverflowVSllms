/*
 * Decompiled with CFR 0.152.
 */
public class OrderNumberObfuscator_1 {
    private static final int NUM_ROUNDS = 4;
    private static final int KEY = 305419896;

    public static long obfuscate(long l) {
        long l2 = l;
        for (int i = 0; i < 4; ++i) {
            long l3 = l2 >> 16 & 0xFFFFL;
            long l4 = l2 & 0xFFFFL;
            long l5 = l4 + (0x12345678L ^ l3) & 0xFFFFL;
            l2 = l3 << 16 | l5;
        }
        return l2 % 1000000000L;
    }

    public static long deobfuscate(long l) {
        long l2 = l;
        for (int i = 0; i < 4; ++i) {
            long l3 = l2 >> 16 & 0xFFFFL;
            long l4 = l2 & 0xFFFFL;
            long l5 = l4 - (0x12345678L ^ l3) & 0xFFFFL;
            l2 = l3 << 16 | l5;
        }
        return l2;
    }

    public static void main(String[] stringArray) {
    }
}
