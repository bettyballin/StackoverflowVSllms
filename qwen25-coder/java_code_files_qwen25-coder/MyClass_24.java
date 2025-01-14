import java.sql.*;

public class MyClass {
    private static final String QUICK_SEARCH = "select * from c where NAME like ?";

    public static void main(String[] args) throws SQLException {
        // Replace this with your actual database connection code
        Connection connection = null;

        // Usage example:
        try (PreparedStatement stmt = connection.prepareStatement(QUICK_SEARCH)) {
            // Ensure that the value you set for the placeholder includes the wildcards%
            stmt.setString(1, "%your_search_term%");
            ResultSet rs = stmt.executeQuery();
            // process results
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}