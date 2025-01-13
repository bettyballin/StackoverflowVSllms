import java.sql.*;

public class DatabaseQueryExecutor_1_1 {
    public static void main(String[] args) throws SQLException {
        // Create a connection to the database
        Connection conn = DriverManager.getConnection("url", "user", "password");

        // Create a prepared statement
        PreparedStatement pstmt = conn.prepareStatement(
            "SELECT A, B, C " +
            "FROM aTbl, bTbl LEFT JOIN cTbl ON bTbl.cTblID = cTbl.objectkey " +
            "WHERE aTbl.objectkey = bTbl.parentkey AND aTbl.flag1 = ?"
        );

        // Set the bind variable
        int flag1Value = 1; // Replace with your actual value
        pstmt.setInt(1, flag1Value);

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        // Process the result set
        while (rs.next()) {
            System.out.println(rs.getString("A") + ", " + rs.getString("B") + ", " + rs.getString("C"));
        }

        // Close the resources
        rs.close();
        pstmt.close();
        conn.close();
    }
}