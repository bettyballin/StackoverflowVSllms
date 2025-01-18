import java.sql.*;

public class PreparedStatementExample_2 {
    public static void main(String[] args) {
        String sql = "INSERT INTO TABLE_NAME (column1, column2) VALUES (?, ?);";
        Connection connection = null; // Assuming a valid connection is established
        PreparedStatement pstmt = null;
        int value1 = 123; // Example value
        String value2 = "abc"; // Example value

        try {
            pstmt = connection.prepareStatement(sql);

            // Set the values for the parameters
            pstmt.setInt(1, value1);  // The first '?' in SQL string is assigned with 'value1'
            pstmt.setString(2, value2); // The second '?' in SQL string is assigned with 'value2'

            int rowsAffected = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close(); // Closing statement
                } catch (SQLException sqlexception) {
                    /* Ignored */
                }
            }
        }
    }
}