import java.sql.*;

public class MySQLPaginator {
    public static void main(String[] args) {
        // Using Java and MySQL
        String dbUrl = "jdbc:mysql://localhost:3306/database_name";
        String username = "username";
        String password = "password";
        int recordsPerPage = 10;
        int offset = 0;

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM table_name LIMIT ? OFFSET ?");
            pstmt.setInt(1, recordsPerPage);
            pstmt.setInt(2, offset);
            ResultSet results = pstmt.executeQuery();

            // Process the results
            while (results.next()) {
                // Handle each row
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}