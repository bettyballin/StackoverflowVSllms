import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Example of a simple N-to-1 model within an application layer
public class DatabaseConnectionManager {
    private Connection connection;

    public void connect() throws SQLException {
        // Single database user for all application users
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "app_user", "secureP@ssw0rd");
    }

    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
    }
}