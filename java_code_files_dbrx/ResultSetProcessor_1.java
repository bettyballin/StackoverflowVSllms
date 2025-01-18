import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetProcessor_1 {
    public static void main(String[] args) {
        String sql = "SELECT column1, column2, column3 FROM table";
        String dbURL = null; // dbURL needs to be defined
        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            pstmt.setFetchSize(500); // Adjust this value accordingly; you may want to test different sizes for best performance
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String column1 = rs.getString("column1");
                    int column2 = rs.getInt("column2");
                    // Process columns accordingly
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}