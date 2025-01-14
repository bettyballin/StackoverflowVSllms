import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class FetchEfficientQueryExecutor {

    private static final String DB_URL = "...";
    private static final String USER = "...";
    private static final String PASS = "...";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {

            // Set the fetch size to reduce memory usage
            stmt.setFetchSize(Integer.MIN_VALUE);

            try (ResultSet rs = stmt.executeQuery("SELECT * FROM large_table")) {
                while (rs.next()) {
                    // Process each row
                }
            }

            conn.commit(); // Commit the transaction after processing

        } catch (SQLException e) {
            // Handle exception and rollback if needed
        }
    }
}