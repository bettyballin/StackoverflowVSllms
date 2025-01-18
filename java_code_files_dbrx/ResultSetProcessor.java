import java.util.Set;
import java.lang.String;
import java.sql.*;

public class ResultSetProcessor {
    static Connection conn;

    public static void main(String[] args) throws SQLException {
        Statement stmt=conn.createStatement(); // create Statement object
        stmt.setFetchSize(4);   /*Set Fetch Size for Statement Object  */
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");
        while (rs.next()) {
            // Process each row here…
        }
    }
}