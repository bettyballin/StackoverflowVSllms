import java.lang.String;
import java.util.concurrent.TimeUnit;

public class TimeConverter {
    public static void main(String[] args) {
        long timeInMilliseconds = 1000L;  // example value
        long elapsedSeconds = TimeUnit.MILLISECONDS.toSeconds(timeInMilliseconds);
        System.out.println("Elapsed time in seconds: " + elapsedSeconds);
    }
}