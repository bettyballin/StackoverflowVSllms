/*
 * Decompiled with CFR 0.152.
 */
public class CpuLoadGenerator {
    public static void main(String[] stringArray) {
        long l = 500L;
        long l2 = System.currentTimeMillis();
        while (System.currentTimeMillis() - l2 < l) {
            double d = 0.0;
            for (int i = 0; i < 100000; ++i) {
                d += Math.sin(i) * Math.cos(i);
            }
        }
    }
}
