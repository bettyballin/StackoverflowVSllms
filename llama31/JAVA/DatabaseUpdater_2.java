import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUpdater_2_2 {
    public static void main(String[] args) {
        Thread delayedThread = new Thread(() -> {
            try {
                Thread.sleep(3 * 60 * 1000); // 3 minutes
                // Execute SQL query here
                Connection conn = DriverManager.getConnection("your_database_url");
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE your_table SET checking_status = 'success'");
                conn.close();
            } catch (InterruptedException | SQLException e) {
                // Handle exceptions
                e.printStackTrace();
            }
        });
        delayedThread.start();
    }
}