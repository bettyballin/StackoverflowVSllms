import java.lang.String;
import java.sql.*;

public class UserDataInserter {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public void insertData(String userName, String userEmail, byte[] imageData) {
        Connection conn = null;
        PreparedStatement userStmt = null;
        PreparedStatement imageStmt = null;

        try {
            // Connect to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Start transaction
            conn.setAutoCommit(false);

            // Prepare SQL statement for user table
            String sqlUser = "INSERT INTO users (name, email) VALUES (?, ?)";
            userStmt = conn.prepareStatement(sqlUser, Statement.RETURN_GENERATED_KEYS);
            userStmt.setString(1, userName);
            userStmt.setString(2, userEmail);
            
            // Execute user insert
            int affectedRows = userStmt.executeUpdate();
            if (affectedRows == 0)
                throw new SQLException("Creating user failed, no rows affected.");

            // Retrieve generated user ID to associate with image
            try (ResultSet generatedKeys = userStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userId = generatedKeys.getInt(1);

                    // Prepare SQL statement for image table
                    String sqlImage = "INSERT INTO images (user_id, image_data) VALUES (?, ?)";
                    imageStmt = conn.prepareStatement(sqlImage);
                    imageStmt.setInt(1, userId);
                    imageStmt.setBytes(2, imageData);

                    // Execute image insert
                    affectedRows = imageStmt.executeUpdate();
                    if (affectedRows == 0)
                        throw new SQLException("Creating image failed, no rows affected.");
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            // Commit transaction
            conn.commit();

        } catch (SQLException ex) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e) {
                System.err.println("Rollback error: " + e.getMessage());
            }
            System.err.println(ex.getMessage());
        } finally {
            // Close resources
            try {
                if (imageStmt != null) imageStmt.close();
                if (userStmt != null) userStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static void main(String[] args) {
	}
}