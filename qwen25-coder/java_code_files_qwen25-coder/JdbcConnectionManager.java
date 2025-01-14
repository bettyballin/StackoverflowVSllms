import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionManager {
    Connection conn = null;

    public JdbcConnectionManager() {
        try {
            conn = DriverManager.getConnection("jdbc:...");
            // Use connection here
        } catch (SQLException e) {
            // Handle exception
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // Log or handle the exception from close()
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}