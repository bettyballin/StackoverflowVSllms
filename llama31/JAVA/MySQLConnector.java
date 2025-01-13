import java.lang.String;
// Example Java code to connect to a MySQL database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/database";
        String username = "username";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("product_name"));
            }

            // Close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}