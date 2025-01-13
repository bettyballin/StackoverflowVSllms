import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TopicQueryPreparedStatementBuilder {
    public static void main(String[] args) {
        // Create a connection to the database
        // For simplicity, let's assume it's already created and passed to the method
        Connection connection = getConnection(); // Implement this method to get a connection

        try {
            PreparedStatement pstmt = connection.prepareStatement(
                "SELECT * FROM bb_topics WHERE topic_poster = ? AND topic_id IN (" +
                "  (SELECT MAX(topic_id) FROM bb_topics WHERE topic_poster = ? AND topic_id < ?)," +
                "  (SELECT MIN(topic_id) FROM bb_topics WHERE topic_poster = ? AND topic_id > ?)" +
                ")"
            );

            pstmt.setInt(1, 5);
            pstmt.setInt(2, 5);
            pstmt.setInt(3, 123);
            pstmt.setInt(4, 5);
            pstmt.setInt(5, 123);

            // You may want to execute the query here
            // pstmt.executeQuery();

        } catch (SQLException e) {
            System.out.println("An error occurred while preparing the statement: " + e.getMessage());
        }
    }

    // Implement this method to get a connection to your database
    private static Connection getConnection() {
        // Implement me
        return null;
    }
}