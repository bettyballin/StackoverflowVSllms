import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class OracleConnectionPoolManager {
    public static void main(String[] args) throws SQLException {
        // Create an Oracle connection pool
        OracleDataSource ds = new OracleDataSource();
        ds.setURL("url");
        ds.setUser("user");
        ds.setPassword("password");
        ds.setConnectionCachingEnabled(true);

        // Get two connections from the pool
        Connection conn1 = ds.getConnection();
        Connection conn2 = ds.getConnection();

        // Create prepared statements on each connection
        PreparedStatement pstmt1 = conn1.prepareStatement("query1");
        PreparedStatement pstmt2 = conn2.prepareStatement("query2");

        // Execute queries concurrently
        pstmt1.executeQuery();
        pstmt2.executeQuery();

        // Close resources
        pstmt1.close();
        pstmt2.close();
        conn1.close();
        conn2.close();
    }
}