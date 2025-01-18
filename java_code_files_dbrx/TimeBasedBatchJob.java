import javax.ejb.*;
import java.util.*;

@Singleton
@Startup
public class TimeBasedBatchJob {
    @Schedule(hour = "23", minute="30") // Set the hour and minute as desired
    public void runTimeBasedBatch() throws InterruptedException {
        System.out.println("Running time-based batch process!");
        /* Your logic here */
    }

    public static void main(String[] args) {
        // Optionally, you can invoke runTimeBasedBatch() here for testing
    }
}