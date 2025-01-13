/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ConnectionManager {
    private final ConcurrentHashMap<String, Connection> connections = new ConcurrentHashMap();
    private final ConcurrentHashMap<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void addConnection(String string, Connection connection) {
        this.connections.put(string, connection);
        ScheduledFuture<?> scheduledFuture = this.scheduler.scheduleAtFixedRate(() -> this.sendKeepAlive(string), 0L, 30L, TimeUnit.MINUTES);
        this.scheduledTasks.put(string, scheduledFuture);
    }

    public void removeConnection(String string) {
        this.connections.remove(string);
        ScheduledFuture<?> scheduledFuture = this.scheduledTasks.remove(string);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    private void sendKeepAlive(String string) {
        Connection connection = this.connections.get(string);
        if (connection != null) {
            connection.sendKeepAlive();
        }
    }

    public static void main(String[] stringArray) {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = new Connection();
        connectionManager.addConnection("123", connection);
    }

    public static class Connection {
        public void sendKeepAlive() {
            System.out.println("Keep alive sent.");
        }
    }
}
