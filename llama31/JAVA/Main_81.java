import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_81 {
    public static void main(String[] args) {
        // Assume 'conn' is a valid Oracle Connection object
        Connection conn = null; 
        String dbUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL"; // Replace with your database URL
        String username = "your_username"; // Replace with your database username
        String password = "your_password"; // Replace with your database password

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return;
        }

        int offset = 0;
        int fetchSize = 100;

        while (true) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM mytable OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
                pstmt.setInt(1, offset);
                pstmt.setInt(2, fetchSize);

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    // Process the row
                }

                if (rs.getFetchSize() < fetchSize) {
                    break; // No more rows to fetch
                }

                offset += fetchSize;
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}