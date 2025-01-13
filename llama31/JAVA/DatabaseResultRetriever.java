import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseResultRetriever {
    public static void main(String[] args) {
        // assuming Connection conn and String tableName
        String tableName = "your_table_name";
        Connection conn = getConnection(); // implement the getConnection method

        String query = "SELECT t1.business_key, t1.result " +
                "FROM " + tableName + " t1 " +
                "INNER JOIN ( " +
                "    SELECT business_key, MAX(id) as max_id " +
                "    FROM " + tableName + " " +
                "    GROUP BY business_key " +
                ") t2 " +
                "ON t1.business_key = t2.business_key AND t1.id = t2.max_id";

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int businessKey = rs.getInt(1);
                int result = rs.getInt(2);
                // process the results
            }
        } catch (SQLException e) {
            // handle the exception
        }
    }

    // implement the getConnection method
    private static Connection getConnection() {
        // implement your database connection logic here
        return null;
    }
}