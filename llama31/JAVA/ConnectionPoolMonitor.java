import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;

public class ConnectionPoolMonitor {
    private MultiThreadedHttpConnectionManager connectionManager;

    public ConnectionPoolMonitor(MultiThreadedHttpConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void printStats() {
        int activeConnections = connectionManager.getConnectionsInPool();
        int idleConnections = connectionManager.getIdleConnections();
        int totalConnections = connectionManager.getTotalConnections();

        System.out.println("Active connections: " + activeConnections);
        System.out.println("Idle connections: " + idleConnections);
        System.out.println("Total connections: " + totalConnections);
    }

    public static void main(String[] args) {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        ConnectionPoolMonitor monitor = new ConnectionPoolMonitor(connectionManager);
        monitor.printStats();
    }
}