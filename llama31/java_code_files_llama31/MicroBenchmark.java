/*
 * Decompiled with CFR 0.152.
 */
public class MicroBenchmark {
    private static final int WARM_UP_ITERATIONS = 1000;
    private static final int MEASUREMENT_ITERATIONS = 10000;

    public static void main(String[] stringArray) {
        for (int i = 0; i < 1000; ++i) {
            MicroBenchmark.performOperation();
        }
        long l = System.nanoTime();
        for (int i = 0; i < 10000; ++i) {
            MicroBenchmark.performOperation();
        }
        long l2 = System.nanoTime();
        long l3 = l2 - l;
        double d = 10000.0 / ((double)l3 / 1.0E9);
        System.out.println("Iterations per second: " + d);
    }

    private static void performOperation() {
        int n = 0;
        for (int i = 0; i < 100; ++i) {
            n += i;
        }
    }
}
