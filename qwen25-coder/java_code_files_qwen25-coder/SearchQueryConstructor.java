import java.util.Arrays;
import java.util.List;
import java.sql.*;

public class SearchQueryConstructor {
    public static void main(String[] args) {
        String DB_URL = "jdbc:your_database_url";
        String USER = "your_username";
        String PASS = "your_password";
        String input = args.length > 0 ? args[0] : "";
        String query = "SELECT * FROM table WHERE 1=1";
        List<String> searchStrings = Arrays.asList(input.split("\\s+"));

        for (String searchString : searchStrings) {
            // Assuming searchString is already properly sanitized if necessary
            query += " AND (field1 LIKE ? OR field2 LIKE ? OR field3 LIKE ?)";
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            int index = 1;
            for (String searchString : searchStrings) {
                String pattern = "%" + searchString + "%";
                pstmt.setString(index++, pattern);
                pstmt.setString(index++, pattern);
                pstmt.setString(index++, pattern);
            }

            ResultSet rs = pstmt.executeQuery();
            // process result set
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}