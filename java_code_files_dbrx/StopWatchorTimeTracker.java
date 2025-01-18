import java.lang.String;
public class StopWatchorTimeTracker {
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); // get starting time before event
        // Your code/event here...
        long end = System.currentTimeMillis(); // get ending time after event
        double elapsedTimeInSec = (end - start) / 1000d; // subtract and convert to seconds
        System.out.println("The elapsed time is " + String.format("%.3f", elapsedTimeInSec) + " sec.");
    }
}