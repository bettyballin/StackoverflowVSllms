import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectorThread {
    Thread thread = new Thread(new Runnable() {
        public void run() {
            Connection conn = null;
            try {
                // Your database code here
                conn = DriverManager.getConnection("your_url", "your_user", "your_password");
                // ...
            } catch (SQLException e) {
                // Handle the exception
            } finally {
                if (Thread.currentThread().isInterrupted()) {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        // Handle the exception
                    }
                }
            }
        }
    });

    public static void main(String[] args) {
        DatabaseConnectorThread databaseConnectorThread = new DatabaseConnectorThread();
        databaseConnectorThread.thread.start();

        // Later, when you want to stop the thread
        databaseConnectorThread.thread.interrupt();
    }
}