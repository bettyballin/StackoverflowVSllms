import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final int MAX_CONNECTIONS = 5;
    private List<Connection> connections;
    private List<Connection> usedConnections;

    private ConnectionPool() {
        this.connections = new ArrayList<>();
        this.usedConnections = new ArrayList<>();
        
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                connections.add(conn);
            } catch (SQLException e) {
                throw new RuntimeException("Failed to initialize connection pool", e);
            }
        }
    }

    public static ConnectionPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public synchronized Connection getConnection() throws SQLException {
        if (connections.isEmpty()) {
            throw new RuntimeException("No connections available");
        }
        
        Connection conn = connections.remove(0);
        usedConnections.add(conn);
        return conn;
    }

    public synchronized void releaseConnection(Connection connection) {
        if (usedConnections.contains(connection)) {
            usedConnections.remove(connection);
            connections.add(connection);
        } else {
            throw new IllegalArgumentException("This is not a managed connection");
        }
    }

    // Optionally, you can add code to clean up unused connections

    public static void main(String[] args) {
    }
}