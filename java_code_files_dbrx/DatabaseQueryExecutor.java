import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseQueryExecutor {
    public static void main(String[] args) {
        String sql = "SELECT * FROM table_name"; // your SQL statement
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            // Process the result set here if needed
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}