import java.util.logging.Logger;

public class MyClass {

    private static final ThreadLocal<Long> MY_TIMING = new ThreadLocal<>(); // or better a custom class to hold timing data
    private static final Logger logger = Logger.getLogger(MyClass.class.getName());

    public static void main(String[] args) {
        // wherever the execution starts...
        try {
            // Start timing
            MY_TIMING.set(System.currentTimeMillis());

            // ... Your code execution ...

            // Simulating some work with Thread.sleep
            Thread.sleep(500); // Sleep for 500 milliseconds

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            long elapsed = System.currentTimeMillis() - MY_TIMING.get(); // in milliseconds or however desired
            logger.info("Operation took " + elapsed + " ms.");
        }
    }
}