import java.lang.String;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class RefCursorExample {
    public static void main(String[] args) {
        // Load the JDBC driver
        String dbUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            // Create a CallableStatement to call the stored procedure
            String sql = "{call your_procedure_name(?) }";
            CallableStatement cs = conn.prepareCall(sql);

            // Register the REF CURSOR as an out parameter
            cs.registerOutParameter(1, Types.REF_CURSOR);

            // Execute the stored procedure
            cs.execute();

            // Get the REF CURSOR as a ResultSet
            ResultSet rs = (ResultSet) cs.getObject(1);

            // Process the ResultSet
            while (rs.next()) {
                System.out.println(rs.getString(1)); // Print the first column
            }

            // Close the ResultSet and CallableStatement
            rs.close();
            cs.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}