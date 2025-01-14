import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {
    public void insertData(String username, String fullName) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Obtain a database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");

            // Create a SQL statement with placeholders for parameters
            String sql = "INSERT INTO Users (username, full_name) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Set the values of the parameters
            pstmt.setString(1, username);  // Set value for the first placeholder (1-indexed)
            pstmt.setString(2, fullName);  // Set value for the second placeholder

            // Execute the update
            int affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // You can test the insertData method here if needed
    }
}