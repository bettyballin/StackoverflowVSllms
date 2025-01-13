/*
 * Decompiled with CFR 0.152.
 */
public class SynchronizationBenchmark {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        int n;
        int n2;
        int n3 = 1000000;
        Object object = new Object();
        long l = System.nanoTime();
        for (int i = 0; i < n3; ++i) {
            Object object2 = object;
            synchronized (object2) {
                n2 = 0;
                for (n = 0; n < 100; ++n) {
                    n2 += n;
                }
                continue;
            }
        }
        long l2 = System.nanoTime();
        System.out.println("Synchronized time: " + (l2 - l) + " ns");
        l = System.nanoTime();
        for (n2 = 0; n2 < n3; ++n2) {
            n = 0;
            for (int i = 0; i < 100; ++i) {
                n += i;
            }
        }
        l2 = System.nanoTime();
        System.out.println("Unsynchronized time: " + (l2 - l) + " ns");
    }
}
