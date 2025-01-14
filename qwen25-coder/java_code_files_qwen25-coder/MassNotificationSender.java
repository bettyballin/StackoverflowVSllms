import java.lang.String;
import java.sql.*;

public class MassNotificationSender {
    public static void main(String[] args) {
        String url = "jdbc:yourDatabaseUrl";
        String user = "dbUser";
        String password = "dbPassword";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false); // Disable auto-commit to use transactions
            String sql = "INSERT INTO notifications (user_id, message) VALUES (?, ?)";
            
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                for (int i = 1; i <= 10000; i++) { // Assuming user IDs are from 1 to 10000
                    pstmt.setInt(1, i); // User ID
                    pstmt.setString(2, "Global Notification Message");
                    pstmt.addBatch(); // Add command to batch

                    if (i % 100 == 0) { // Execute every batch of 100 inserts
                        pstmt.executeBatch();
                        connection.commit(); // Commit the transaction
                    }
                }

                // Handle any remaining rows
                pstmt.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(); // Rollback in case of error
                throw e;
            } finally {
                connection.setAutoCommit(true); // Re-enable auto-commit
            }
        } catch (SQLException e) {
            System.out.println("Database access error: " + e.getMessage());
        }
    }
}