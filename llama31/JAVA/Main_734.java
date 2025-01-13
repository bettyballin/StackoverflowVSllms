import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_734 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Obtain a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            
            String query = "SELECT * FROM users WHERE name = ? AND age = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "John");
                pstmt.setInt(2, 30);
                try (ResultSet results = pstmt.executeQuery()) {
                    // Process results
                    while (results.next()) {
                        System.out.println(results.getString("name") + " " + results.getInt("age"));
                    }
                }
            }
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