import java.lang.String;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Added Server class for compilation
class Server {
    public void sendHeartbeat() {
        System.out.println("Heartbeat sent");
    }
}

public class HeartbeatSender {
    private final ScheduledExecutorService scheduler;

    public HeartbeatSender() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void startHeartbeat(Server server) {
        scheduler.scheduleAtFixedRate(new HeartbeatTask(server), 0, 15, TimeUnit.SECONDS);
    }

    private static class HeartbeatTask implements Runnable {
        private final Server server;

        public HeartbeatTask(Server server) {
            this.server = server;
        }

        @Override
        public void run() {
            // Send heartbeat message to server
            server.sendHeartbeat();
        }
    }

    public static void main(String[] args) {
        // Create Server and HeartbeatSender instances
        Server server = new Server();
        HeartbeatSender heartbeatSender = new HeartbeatSender();
        
        // Start the heartbeat
        heartbeatSender.startHeartbeat(server);
    }
}