import java.lang.String;
import org.junit.Test;

public class StackSizeTest {

    @Test(expected = StackOverflowError.class)
    public void testForEndlessRecursion() throws InterruptedException {
        // Create a thread with a reduced stack size and run the test logic in that thread
        Thread thread = new Thread(null, () -> endlessRecursion(), "RecursionThread", 128 * 1024); // 128 KB stack size

        // Start the thread, wait for it to finish or throw an exception
        thread.start();
        thread.join();
    }

    private void endlessRecursion() {
        endlessRecursion(); // This will cause a StackOverflowError when stack space runs out
    }

    public static void main(String[] args) {
    }
}