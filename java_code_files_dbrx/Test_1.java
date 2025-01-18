import java.lang.String;
public class Test_1 {
    public static void main(String[] args) throws Exception {
        // Let's imagine this object is very large.
        Object bigObject = new byte[1024 * 1024]; // 1 MB array.

        try {
            Object foo = "bar"; // This will shadow `bigObject`.
            System.out.println("Inside scope: " + bigObject);
        } finally {
            System.gc(); // Request a garbage collection cycle.
            Thread.sleep(100);
        }

        // At this point, the JVM is free to reclaim `bigObject`.
        System.out.println("Outside scope: " + bigObject); // Should print 'null' if freed up correctly.
    }
}