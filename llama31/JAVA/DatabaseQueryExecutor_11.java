import java.sql.*;

public class DatabaseQueryExecutor_11_11 {
    public static void main(String[] args) throws SQLException {
        // Assuming you have a database connection established
        Connection conn = DriverManager.getConnection("url", "user", "password");

        String userInput = "someUserInput"; // Replace with actual user input
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM mytable WHERE mycolumn = ?");
        pstmt.setString(1, userInput);
        ResultSet results = pstmt.executeQuery();

        // Process the results
        while (results.next()) {
            // Do something with the results
        }

        // Close the resources
        results.close();
        pstmt.close();
        conn.close();
    }
}