import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class OracleCursorFetcher {

    public static void main(String[] args) {
        OracleCursorFetcher fetcher = new OracleCursorFetcher();
        fetcher.fetchCursor();
    }

    public void fetchCursor() {
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

            CallableStatement cs = conn.prepareCall("BEGIN S_S_TEST(?); END;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(1);
            // Use the result set
            // ...
            rs.close();
            cs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL exception: " + e.getMessage());
        }
    }
}