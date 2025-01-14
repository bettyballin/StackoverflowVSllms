import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String sql = "INSERT INTO myTable (Column1, Column2, Column3) VALUES (?, ?, ?)";
        Connection connection = null; // Initialize your database connection here

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Assuming Column1 is of type INTEGER, Column2 is VARCHAR(255), and Column3 is DATE
            pstmt.setInt(1, 1); // First placeholder value
            pstmt.setString(2, "Sample Data"); // Second placeholder value
            pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Third placeholder value

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("A row has been inserted successfully.");
            }
        } catch (SQLException ex) {
            System.err.println("Error saving data: " + ex.getMessage());
        }
    }
}