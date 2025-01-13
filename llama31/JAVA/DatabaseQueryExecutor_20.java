import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseQueryExecutor_20_20 {
    public static void main(String[] args) throws Exception {
        // Load the JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Establish a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "username", "password");

        // Create a prepared statement
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM table_name WHERE CONTAINS(text_column, ?) > 0");

        // Set the parameter
        pstmt.setString(1, "key2=def");

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        // Close the result set, statement, and connection
        rs.close();
        pstmt.close();
        conn.close();
    }
}