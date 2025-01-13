import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ConnectionManager {
    private final ConcurrentHashMap<String, Connection> connections = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void addConnection(String id, Connection connection) {
        connections.put(id, connection);
        ScheduledFuture<?> task = scheduler.scheduleAtFixedRate(() -> sendKeepAlive(id), 0, 30, TimeUnit.MINUTES);
        scheduledTasks.put(id, task);
    }

    public void removeConnection(String id) {
        connections.remove(id);
        ScheduledFuture<?> task = scheduledTasks.remove(id);
        if (task != null) {
            task.cancel(true);
        }
    }

    private void sendKeepAlive(String id) {
        Connection connection = connections.get(id);
        if (connection != null) {
            connection.sendKeepAlive();
        }
    }

    public static class Connection {
        public void sendKeepAlive() {
            System.out.println("Keep alive sent.");
        }
    }

    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = new Connection();
        connectionManager.addConnection("123", connection);
    }
}