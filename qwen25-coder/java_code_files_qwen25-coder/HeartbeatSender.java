import java.lang.String;
public class HeartbeatSender {
    // Server-side pseudo code for heartbeat
    public void sendHeartbeat(ClientConnection connection) {
        long currentTime = System.currentTimeMillis();
        connection.sendCommand("heartbeat", currentTime);
    }

    public static void main(String[] args) {
    }
}

class ClientConnection {
    public void sendCommand(String command, long time) {
        // Do nothing
    }
}