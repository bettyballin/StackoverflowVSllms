/*
 * Decompiled with CFR 0.152.
 */
public class FeistelShuffle {
    private static final int NUM_ROUNDS = 4;
    private static final int MASK = Integer.MAX_VALUE;

    public static int shuffle(int n) {
        int n2 = n;
        for (int i = 0; i < 4; ++i) {
            n2 = (n2 ^ (n2 & Integer.MAX_VALUE) >>> 16) & Integer.MAX_VALUE;
            n2 = (n2 ^ (n2 & Integer.MAX_VALUE) << 16) & Integer.MAX_VALUE;
        }
        return n2;
    }

    public static int unshuffle(int n) {
        int n2 = n;
        for (int i = 0; i < 4; ++i) {
            n2 = (n2 ^ (n2 & Integer.MAX_VALUE) >>> 16) & Integer.MAX_VALUE;
            n2 = (n2 ^ (n2 & Integer.MAX_VALUE) << 16) & Integer.MAX_VALUE;
        }
        return n2;
    }

    public static void main(String[] stringArray) {
    }
}
