import java.lang.String;
import java.util.concurrent.TimeUnit;

public class TimerExample {
    public static void main(String[] args) {
        long start = System.nanoTime();
        // ... do something ...
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Duration: " + TimeUnit.NANOSECONDS.toMillis(duration) + " ms");
    }
}