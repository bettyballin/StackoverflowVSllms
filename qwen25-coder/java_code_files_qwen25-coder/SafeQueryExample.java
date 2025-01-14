import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SafeQueryExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO my_table (column1, column2) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, "value1");
                pstmt.setInt(2, 123);

                // Execute the INSERT operation
                int affectedRows = pstmt.executeUpdate();
                System.out.println("Number of rows inserted: " + affectedRows);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}