import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableDataRetriever {
    public static void main(String[] args) {
        // Create a connection to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM table WHERE RTRIM(PRT_STATUS) = ?");
            pstmt.setString(1, "ONT");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}