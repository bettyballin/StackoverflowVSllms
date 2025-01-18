import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static volatile DBConnection instance = null;
    private final Connection connection;

    private DBConnection() throws SQLException, ClassNotFoundException {
        // Register JDBC driver and create database connection here.
        connection = null; // Initialize the final variable
    }

    public static DBConnection getInstance() {
        if (instance == null) {  // Double check locking for performance enhancement
            synchronized (DBConnection.class) {   // Acquire monitor lock for the class object
                // Check one more time to make sure that some other thread has not already created the instance and set its value into 'instance' object, during this brief moment when we released the lock.
                if (instance == null) {
                    try {
                        instance = new DBConnection();  // Create an actual instance of the Class only if it is needed.
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
    }
}