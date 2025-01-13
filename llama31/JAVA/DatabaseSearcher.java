import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseSearcher {
    public static void main(String[] args) {
        // Set up your database connection
        String dbUrl = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password)) {
            String[] searchStrings = {"search_string_1", "search_string_2"}; // Define your search strings

            for (int i = 0; i < searchStrings.length; i++) {
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM table WHERE field1 LIKE ? OR field2 LIKE ? OR field3 LIKE ?");
                pstmt.setString(1, "%" + searchStrings[i] + "%");
                pstmt.setString(2, "%" + searchStrings[i] + "%");
                pstmt.setString(3, "%" + searchStrings[i] + "%");

                try (ResultSet results = pstmt.executeQuery()) {
                    while (results.next()) {
                        // Process your results here
                        System.out.println(results.getString(1)); // Replace with your actual column index
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}