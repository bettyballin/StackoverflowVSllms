import java.lang.String;

public class Profiler {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Code to profile
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Profiled code took " + duration + " nanoseconds");
    }
}