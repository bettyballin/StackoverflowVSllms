import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleResultSetCacheManager {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@//yourserver:port/service";
        Connection conn = DriverManager.getConnection(url, "username", "password");
        conn.setAutoCommit(false); // This is important for enabling server-side caching

        // Set up the statement with scrollable and insensitive results
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setFetchSize(1000); // Adjust fetch size as needed

        ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");
    }
}