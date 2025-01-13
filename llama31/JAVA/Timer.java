import java.lang.String;

public class Timer {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Execute your sorting/searching algorithm here
        long endTime = System.nanoTime();
        long runtime = endTime - startTime;
        System.out.println("Runtime: " + runtime + " nanoseconds");
    }
}