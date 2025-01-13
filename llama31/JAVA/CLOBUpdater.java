import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Reader;
import java.io.StringReader;

public class CLOBUpdater {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

            // Assuming ID and the content to append
            int id = 1;
            String appendContent = "This is the content to append.\n";

            // Fetch the existing CLOB content
            String existingContent = fetchExistingCLOBContent(conn, id);

            // Append the new content to the existing content
            String updatedContent = existingContent + appendContent + "\n";

            // Update the CLOB column with the appended content
            updateCLOBContent(conn, id, updatedContent);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static String fetchExistingCLOBContent(Connection conn, int id) throws SQLException {
        String query = "SELECT log FROM table WHERE id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1); // If the CLOB is not too large, this works. Otherwise, use getCharacterStream or getClob.
            }
            return "";
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void updateCLOBContent(Connection conn, int id, String updatedContent) throws SQLException {
        String query = "UPDATE table SET log = ? WHERE id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setCharacterStream(1, new StringReader(updatedContent), updatedContent.length());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}