import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DynamicQueryBuilder {

    public static void main(String[] args) throws SQLException {
        String sql = "SELECT gpz.zname, gpp.pname FROM table1 gpp INNER JOIN table2 gpz ON gpz.p_id = gpp.p_id WHERE 1=1";
        boolean firstCondition = true;

        boolean isActive = true; // Initialize as needed
        boolean isZActive = true; // Initialize as needed

        if (isActive) {
            if (!firstCondition) {
                sql += " AND";
            }
            sql += " AND gpp.active = ?";
            firstCondition = false;
        }

        if (isZActive) {
            if (!firstCondition) {
                sql += " AND";
            }
            sql += " AND gpz.active = ?";
            firstCondition = false;
        }

        // Prepare and execute the statement
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // Replace with your actual database URL, username, and password
            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            pstmt = connection.prepareStatement(sql);
            int paramIndex = 1;
            if (isActive) {
                pstmt.setInt(paramIndex++, 1); // Assuming active is represented by the integer 1
            }
            if (isZActive) {
                pstmt.setInt(paramIndex++, 1); // Assuming active is represented by the integer 1
            }

            ResultSet rs = pstmt.executeQuery();
            // Process the result set as needed
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* Ignored */ }
        }
    }
}