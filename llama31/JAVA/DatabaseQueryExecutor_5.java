import java.sql.*;

public class DatabaseQueryExecutor_5_5 {
    public static void main(String[] args) throws SQLException {
        // Creating a connection to the database
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";
        
        Connection conn = DriverManager.getConnection(url, username, password);
        
        // Example in Java using PreparedStatements
        int currentId = 1;  // Define currentId
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM your_table WHERE current_id = ?");
        pstmt.setInt(1, currentId);
        ResultSet rs = pstmt.executeQuery();
        
        // Don't forget to close the ResultSet, PreparedStatement, and Connection to avoid resource leaks
        rs.close();
        pstmt.close();
        conn.close();
    }
}