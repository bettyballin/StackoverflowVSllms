import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

class TimeService {
    private final long scaleFactor; // e.g., 365 * 24 * 60 for a year in an hour
    private final AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
    private final AtomicLong simulatedTime = new AtomicLong();

    public TimeService(long scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public LocalDateTime now() {
        long currentTime = System.currentTimeMillis();
        simulatedTime.set(startTime.get() + (currentTime - startTime.get()) * scaleFactor);
        return LocalDateTime.ofEpochSecond(simulatedTime.get() / 1000, 0, java.time.ZoneOffset.UTC);
    }
    
    // Additional methods to manage time as needed
}

// Usage example:
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TimeService timeService = new TimeService(365L * 24 * 60); // approx. a year per hour

        // Use the TimeService to get simulated time
        for (int i = 0; i < 10; i++) {
            System.out.println("Simulated time is: " + timeService.now());
            Thread.sleep(300); // Sleep for a short period to simulate passage of wall-clock time
        }
    }
}