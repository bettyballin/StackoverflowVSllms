import java.lang.String;
public class FunctionTimer {

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Capture start time

        // Call the function you want to measure
        yourFunction();

        long endTime = System.nanoTime(); // Capture end time
        long duration = (endTime - startTime); // Calculate duration in nanoseconds

        System.out.println("Execution time: " + duration + " ns");
    }

    public static void yourFunction() {
        // Your code here
        for (int i = 0; i < 1000000; i++) {
            // Simulate some work
        }
    }
}