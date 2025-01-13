import java.sql.*;

public class UserDatabaseAccessor {
    public static void main(String[] args) throws SQLException {
        // Create a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Create a PreparedStatement
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
        String username = "example"; // Set the username
        pstmt.setString(1, username);

        // Execute the query
        ResultSet results = pstmt.executeQuery();

        // Print the results
        while (results.next()) {
            System.out.println(results.getString(1)); // Print the first column
        }

        // Close the connection
        conn.close();
    }
}