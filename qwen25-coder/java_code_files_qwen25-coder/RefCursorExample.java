import java.lang.String;
import java.sql.*;

public class RefCursorExample {
    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement callStmt = null;
        ResultSet rs = null;

        try {
            // Establishing a connection to the database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@host:port:sid", "username", "password");

            // Preparing callable statement to execute stored procedure that returns REF CURSOR
            callStmt = conn.prepareCall("{ ? = call your_package.your_procedure }");

            // Registering the OUT parameter - the REF CURSOR
            callStmt.registerOutParameter(1, Types.OTHER);

            // Executing the stored procedure
            callStmt.execute();

            // Retrieving the ResultSet from the OUT parameter
            rs = (ResultSet) callStmt.getObject(1);

            // Iterating through the result set and processing the data
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources in reverse order of their creation
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (callStmt != null) callStmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}