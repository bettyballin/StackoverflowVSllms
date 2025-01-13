import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserImageDatabaseTransaction {
    public static void main(String[] args) {
        // Assuming you have a Connection object 'conn'
        Connection conn = null; // Initialize conn
        String name = "John Doe"; // Initialize name
        String email = "john.doe@example.com"; // Initialize email
        String password = "password123"; // Initialize password
        int userId = 1; // Initialize userId
        byte[] imageData = new byte[0]; // Initialize imageData

        try {
            // Start a transaction
            conn.setAutoCommit(false);

            // Insert user details into the user table
            String userInsertQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement userStmt = conn.prepareStatement(userInsertQuery);
            userStmt.setString(1, name);
            userStmt.setString(2, email);
            userStmt.setString(3, password);
            userStmt.executeUpdate();

            // Insert image details into the image table
            String imageInsertQuery = "INSERT INTO images (user_id, image_data) VALUES (?, ?)";
            PreparedStatement imageStmt = conn.prepareStatement(imageInsertQuery);
            imageStmt.setInt(1, userId); // Assuming you have the user ID
            imageStmt.setBytes(2, imageData); // Assuming you have the image data
            imageStmt.executeUpdate();

            // Commit the transaction
            conn.commit();
        } catch (SQLException e) {
            // Rollback the transaction if an error occurs
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error rolling back transaction: " + ex.getMessage());
                }
            }
            System.out.println("Error executing transaction: " + e.getMessage());
        } finally {
            // Reset auto-commit to true
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException ex) {
                    System.out.println("Error resetting auto-commit: " + ex.getMessage());
                }
            }
        }
    }
}