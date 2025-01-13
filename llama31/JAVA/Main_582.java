import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;
import java.sql.DriverManager;

public class Main_582 {
    public static void main(String[] args) throws Exception {
        // Create a connection to the database
        OracleConnection conn = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

        // Create a statement to capture changes
        OraclePreparedStatement pstmt = (OraclePreparedStatement) conn.prepareStatement("BEGIN DBMS_CDC_PUBLISH.CREATE_CHANGE_SET(:1, :2); END;");

        // Set the change set name and table name
        pstmt.setString(1, "my_change_set");
        pstmt.setString(2, "my_table");

        // Execute the statement
        pstmt.execute();

        // Close the statement and connection
        pstmt.close();
        conn.close();
    }
}