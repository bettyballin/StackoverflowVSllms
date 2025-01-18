import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StayAlive {

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        new StayAlive().start();
    }

    public void start() {
        executor.scheduleAtFixedRate(() -> {
            try {
                // Send your stay alive message here.
                System.out.println("I am staying alive!");
            } catch (Exception e) {
                // Handle exception if sending heartbeat fails.
            }
        }, 0, 15, TimeUnit.SECONDS);
    }
}