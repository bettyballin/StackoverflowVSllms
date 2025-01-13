/*
 * Decompiled with CFR 0.152.
 */
public class RoundingUtil {
    public static int roundToNearest100(int n) {
        return (n + 50) / 100 * 100;
    }

    public static void main(String[] stringArray) {
    }
}
