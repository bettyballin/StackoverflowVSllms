import java.sql.*;
import oracle.jdbc.OracleTypes;

public class DatabaseQueryExecutor_19_19 {
    public static void main(String[] args) throws SQLException {
        // Create a connection object (this should be replaced with your actual connection code)
        Connection conn = DriverManager.getConnection("your_database_url", "your_username", "your_password");

        // Create a PreparedStatement object
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM table WHERE PRT_STATUS = ?");

        // Set the parameter
        pstmt.setObject(1, "ONT", OracleTypes.FIXED_CHAR);

        // You may want to execute the query and process the results here
        // pstmt.executeQuery();

        // Close the statement and connection to avoid resource leaks
        pstmt.close();
        conn.close();
    }
}