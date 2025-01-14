import java.lang.String;
import java.sql.*;

public class MssqlQuery {
    public static String exec(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Assume ODBC driver is configured and TNS listener directs to SQL Server
            conn = DriverManager.getConnection("jdbc:oracle:thin:@ODBCdsn", "user", "password");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1); // Assuming we expect a single column result
            }
        } finally {
            // It's important to close resources in all cases.
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return "No result";
    }

    public static void main(String[] args) {
    }
}