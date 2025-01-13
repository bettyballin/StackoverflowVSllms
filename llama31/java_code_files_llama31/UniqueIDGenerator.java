/*
 * Decompiled with CFR 0.152.
 */
public class UniqueIDGenerator {
    private static final int TIMESTAMP_BITS = 40;
    private static final int RANDOM_BITS = 24;

    public static long getUniqueID() {
        long l = System.currentTimeMillis() << 24;
        long l2 = (long)(Math.random() * 1.6777216E7);
        return l | l2;
    }

    public static void main(String[] stringArray) {
    }
}
