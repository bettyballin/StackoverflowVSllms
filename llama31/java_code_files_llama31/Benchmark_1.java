/*
 * Decompiled with CFR 0.152.
 */
public class Benchmark_1 {
    public static void main(String[] stringArray) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; ++i) {
            Math.sqrt(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("Execution time: " + (l2 - l) + "ms");
    }
}
