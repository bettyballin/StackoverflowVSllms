import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataMerger {
    public static void main(String[] args) {
        String query = "MERGE INTO data d USING (SELECT ? as id, ? as key, ? as value FROM dual) s " +
                "ON (d.id = ? AND d.key = ?) " +
                "WHEN MATCHED THEN UPDATE SET d.value = ? " +
                "WHEN NOT MATCHED THEN INSERT (id, key, value) VALUES (?, ?, ?)";

        String url = "jdbc:oracle:thin:@//localhost:1521/ORCL"; // replace with your database URL
        String username = "username"; // replace with your database username
        String password = "password"; // replace with your database password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, "someid");
            pstmt.setString(2, "testKey");
            pstmt.setString(3, "someValue");
            pstmt.setString(4, "someid");
            pstmt.setString(5, "testKey");
            pstmt.setString(6, "someValue");
            pstmt.setString(7, "someid");
            pstmt.setString(8, "testKey");
            pstmt.setString(9, "someValue");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}