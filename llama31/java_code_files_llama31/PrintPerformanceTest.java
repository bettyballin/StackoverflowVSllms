/*
 * Decompiled with CFR 0.152.
 */
import java.util.logging.Logger;

public class PrintPerformanceTest {
    public static void main(String[] stringArray) {
        int n = 100000;
        long l = System.nanoTime();
        for (int i = 0; i < n; ++i) {
            System.out.println("Test");
        }
        long l2 = System.nanoTime();
        System.out.println("System.out.println() took: " + (l2 - l) + "ns");
        Logger logger = Logger.getLogger(PrintPerformanceTest.class.getName());
        l = System.nanoTime();
        for (int i = 0; i < n; ++i) {
            logger.info("Test");
        }
        l2 = System.nanoTime();
        System.out.println("Logger took: " + (l2 - l) + "ns");
    }
}
