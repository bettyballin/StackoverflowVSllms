import java.sql.*;

public class MyViewQueryExecutor {
    public static void main(String[] args) throws SQLException {
        Connection con = null; // Initialize your database connection here
        int value = 0; // Replace with the appropriate variable or constant

        String query = "SELECT * FROM my_view WHERE flag1=?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, value); // replace 'value' with the appropriate variable or constant
        ResultSet result = pstmt.executeQuery();

        // Optionally process the ResultSet 'result' here

        // Close resources (in a real application, use try-with-resources or handle exceptions)
        result.close();
        pstmt.close();
        con.close();
    }
}