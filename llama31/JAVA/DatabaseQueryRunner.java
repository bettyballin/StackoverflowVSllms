import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryRunner {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Create a prepared statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM mytable WHERE id = ?");
            pstmt.setInt(1, 1);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Process the results
            while (rs.next()) {
                // Do something with the results
                System.out.println(rs.getString(1));
            }

            // Close the resources
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
        }
    }
}