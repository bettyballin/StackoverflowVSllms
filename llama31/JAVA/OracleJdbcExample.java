import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJdbcExample {
    public static void main(String[] args) {
        // Replace with your Oracle database credentials and URL
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "your_username";
        String password = "your_password";

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);

            // Create a statement and execute a query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString(1) + ", " + rs.getString(2));
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Oracle JDBC driver not found.");
        }
    }
}