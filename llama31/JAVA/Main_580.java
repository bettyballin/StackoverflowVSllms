import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main_580_580 {
    public static void main(String[] args) throws Exception {
        // Load the PostgreSQL JDBC driver
        Class.forName("org.postgresql.Driver");

        // Connect to the database
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase", "myuser", "mypassword");

        // Create a prepared statement
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM site WHERE site_id = ?");

        // Set the parameter
        pstmt.setInt(1, 3);

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        // Process the results
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }

        // Close the resources
        rs.close();
        pstmt.close();
        conn.close();
    }
}