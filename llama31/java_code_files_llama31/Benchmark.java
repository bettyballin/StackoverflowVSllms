/*
 * Decompiled with CFR 0.152.
 */
public class Benchmark {
    public static void main(String[] stringArray) {
        long l = System.nanoTime();
        for (int i = 0; i < 10000000; ++i) {
            int n = i * 2;
        }
        long l2 = System.nanoTime();
        System.out.println("Execution time: " + (l2 - l) + " ns");
    }
}
