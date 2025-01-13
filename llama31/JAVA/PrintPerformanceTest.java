import java.lang.String;
import java.util.logging.Logger;

public class PrintPerformanceTest {
    public static void main(String[] args) {
        int iterations = 100000;

        // Using System.out.println()
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            System.out.println("Test");
        }
        long end = System.nanoTime();
        System.out.println("System.out.println() took: " + (end - start) + "ns");

        // Using java.util.logging.Logger
        Logger logger = Logger.getLogger(PrintPerformanceTest.class.getName());
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            logger.info("Test");
        }
        end = System.nanoTime();
        System.out.println("Logger took: " + (end - start) + "ns");
    }
}