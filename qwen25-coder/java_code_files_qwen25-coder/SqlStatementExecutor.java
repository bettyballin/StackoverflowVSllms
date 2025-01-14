import java.lang.String;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class SqlStatementExecutor {
    Connection conn = null;
    Statement stmt = null;
    DataSource yourConnectionFactory = null;

    public SqlStatementExecutor() {
        try {
            conn = yourConnectionFactory.getConnection();
            stmt = conn.createStatement();
            // Use statement to execute queries
        } catch (SQLException e) {
            // Handle SQLExceptions
        } finally {
            // Close resources in finally blocks to ensure they are closed even if an exception occurs.
            try { 
                if (stmt != null) stmt.close(); 
            } catch (SQLException ex) {}
            try { 
                if (conn != null) conn.close(); 
            } catch (SQLException ex) {} // Return connection to pool
        }
    }
    
    public static void main(String[] args) {
    }
}