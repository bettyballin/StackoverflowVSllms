import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MessageQueueBatchInserter {
    public static void main(String[] args) {
        // assuming you have a Connection object named 'conn'
        Connection conn = null; // initialize your connection object here

        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO msg_queue (user_id, message) VALUES (?, ?)");
            // set batch size to 100
            conn.setAutoCommit(false);
            int batchSize = 100;
            int count = 0;

            List<User> users = null; // initialize your users list here
            String message = null; // initialize your message here

            for (User user : users) {
                pstmt.setInt(1, user.getId());
                pstmt.setString(2, message);
                pstmt.addBatch();
                count++;

                if (count % batchSize == 0) {
                    pstmt.executeBatch();
                    conn.commit();
                    pstmt.clearBatch();
                }
            }

            // execute the remaining batch
            if (count % batchSize != 0) {
                pstmt.executeBatch();
                conn.commit();
            }
        } catch (SQLException e) {
            // handle the SQL exception
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            // close the connection object
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQL Exception while closing connection: " + e.getMessage());
                }
            }
        }
    }
}

// assuming you have a User class with an getId method
class User {
    private int id;

    public int getId() {
        return id;
    }

    // other methods and fields...
}