import java.lang.String;
import java.sql.*;

public class ConnectionCheckExample {
    public static void main(String[] args) throws SQLException {
        // Establish your database connection here using DriverManager or DataSource object
        Connection conn = getConnection();
        if (conn != null && !conn.isClosed()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT 1 FROM DUAL");
            if (rs.next()) {
                System.out.println("JDBC connection is open and working.");
            } else {
                System.out.println("JDBC connection is not valid or database instance is down.");
            }
        } else {
            System.out.println("No active JDBC connection!");
        }
    }

    // This method should return an OracleDataSource or Connection object after proper setup for the connection
    private static Connection getConnection() throws SQLException {
        return null;   // your implementation here to create a Connection instance using DriverManager of DataSource setup
    }
}