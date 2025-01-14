import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateExample {

    public static void updateTable(String[][] myData) {
        String url = "jdbc:sqlserver://your_server_address;databaseName=your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE mytable SET col3 = ? WHERE col1 = ? AND col2 = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (String[] row : myData) {
                    pstmt.setString(1, row[2]);
                    pstmt.setString(2, row[0]);
                    pstmt.setString(3, row[1]);
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[][] myData = {
            {"value1a", "value2a", "new_value3a"},
            {"value1b", "value2b", "new_value3b"}
        };
        updateTable(myData);
    }
}