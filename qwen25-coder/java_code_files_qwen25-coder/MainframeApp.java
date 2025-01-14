import java.lang.String;
public class MainframeApp {
    public static void main(String[] args) {
        System.out.println("Hello from the mainframe!");
        // Example of processing tasks more efficiently
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            // Simulate task processing
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Processing time: " + (endTime - startTime) + " ms");
    }
}