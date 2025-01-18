import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class Main {

    static DataSource dataSource = null;  // initialized appropriately;
    
    public static void executeNonQuery(String query) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(query);
            // Bind parameters, set types and values here...
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle SQLException appropriately; throw or log error details
        } finally {
            if (stmt != null) {
                try {
                    if (!stmt.isClosed()) {
                        stmt.close();
                    }
                } catch (SQLException ex) {}
            }
            if (conn != null) {
                try {
                    if (!conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException ex) {}
            }
        }
    }

    public static void main(String[] args) {
        // For the code to be executable, we need a main method
        // We can call executeNonQuery with some dummy query
        executeNonQuery("SELECT 1");
    }
}