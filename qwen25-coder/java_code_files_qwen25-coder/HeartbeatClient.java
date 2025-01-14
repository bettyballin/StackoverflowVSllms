import java.lang.String;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HeartbeatClient {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final Server server;

    public HeartbeatClient(Server server) {
        this.server = server;
    }

    public void startHeartbeat() {
        Runnable heartbeatTask = () -> {
            try {
                // Send the "stay alive" message to the server
                server.sendKeepAliveMessage();
            } catch (Exception e) {
                System.err.println("Failed to send keep-alive: " + e.getMessage());
            }
        };

        // Schedule the task to run every 15 seconds with an initial delay of 0 seconds
        scheduler.scheduleAtFixedRate(heartbeatTask, 0, 15, TimeUnit.SECONDS);
    }

    public void stopHeartbeat() {
        // Gracefully shutdown the executor service
        scheduler.shutdown();
    }
}

class Server {
    public void sendKeepAliveMessage() {
        // Implementation of sending a keep-alive message to the server
        System.out.println("Sent keep-alive message");
    }

	public static void main(String[] args) {
	}
}