import oracle.jdbc.OracleDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_617 {
    public static void main(String[] args) {
        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish a connection to the Oracle database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();

            // Execute a query to retrieve data from the converted Excel data
            ResultSet rs = stmt.executeQuery("SELECT * FROM converted_excel_data");

            // Close the result set, statement, and connection to free up resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}