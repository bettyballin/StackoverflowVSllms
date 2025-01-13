import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUpdater_1_1 {
    public static void executeNonQuery(String sql, Object... params) {
        // Assume that you have a database connection established
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        executeNonQuery("UPDATE table SET column = ? WHERE id = ?", "value", 123);
    }
}