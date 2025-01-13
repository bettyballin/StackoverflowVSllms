import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_661 {
    private static final String QUICK_SEARCH = "select * from c where NAME like ?";
    private static final String DB_URL = "jdbc:sqlite:example.db"; // Path to your SQLite database

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL); // Initialize your connection here
        String yourSearchTerm = "example"; // Replace with your search term

        try (PreparedStatement pstmt = connection.prepareStatement(QUICK_SEARCH)) {
            pstmt.setString(1, "%" + yourSearchTerm + "%");
            // pstmt.executeQuery(); // Uncomment to execute the query
        }
        connection.close();
    }
}