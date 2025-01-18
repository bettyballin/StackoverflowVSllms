import java.sql.*;
import java.util.Arrays;

public class MultipleUpdates {
    public static void main(String[] args) throws Exception {
        // Your database connection setup here (make sure you have valid credentials and the server is running).
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "your_username";
        String password = "your_password";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = null;
        try {
            // Array of data (myData) as in your example.
            String[][] myData = new String[][] {
                {"value1_col1", "value1_col2", "value1_col3"},
                {"value2_col1", "value2_col2", "value2_col3"}
            };

            String sql = "UPDATE mytable SET col3=? WHERE col1=? AND col2=?";

            for(String[] row : myData) {
                pstmt = conn.prepareStatement(sql);
                // Indexes match those in the myData array and corresponding ones from our query (col1, col2 and col3).
                pstmt.setString(1, row[2]);
                pstmt.setString(2, row[0]);
                pstmt.setString(3, row[1]);

                // Execute the update for each set of values (i.e., each row in myData).
                int updatedRows = pstmt.executeUpdate();
                if(updatedRows == 0) {
                    System.out.println("No rows were updated during iteration with row[" + Arrays.toString(row) + "].");
                } else {
                    System.out.println("Number of rows updated from row data [" + Arrays.toString(row) + "]: " + updatedRows);
                }
            }
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
            // Close database connection as well.
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    }
}