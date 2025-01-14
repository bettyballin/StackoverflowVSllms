import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EventScheduler {
    // Server-side pseudo code

    public void scheduleEvent(Date scheduledTime, List<ClientConnection> connections) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                for (ClientConnection connection : connections) {
                    connection.sendCommand("eventTrigger");
                }
            }
        }, scheduledTime.getTime() - new Date().getTime());
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}

class ClientConnection {
    public void sendCommand(String command) {
        // Implementation here
    }
}