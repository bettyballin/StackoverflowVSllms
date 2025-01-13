import java.sql.Connection;
import java.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_85 {
    public static void main(String[] args) throws SQLException {
        // Create a connection pool
        DataSource dataSource = java.sql.DriverManager.getDataSource();

        // Get two connections from the pool
        Connection conn1 = dataSource.getConnection();
        Connection conn2 = dataSource.getConnection();

        // Create prepared statements on each connection
        PreparedStatement pstmt1 = conn1.prepareStatement("query1");
        PreparedStatement pstmt2 = conn2.prepareStatement("query2");

        // Execute queries concurrently
        pstmt1.executeQuery();
        pstmt2.executeQuery();

        // Close the statements
        pstmt1.close();
        pstmt2.close();

        // Close the connections
        conn1.close();
        conn2.close();
    }
}