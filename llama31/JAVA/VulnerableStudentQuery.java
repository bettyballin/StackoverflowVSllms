import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VulnerableStudentQuery {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your database URL
        String username = "myuser"; // replace with your database username
        String password = "mypassword"; // replace with your database password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM STUDENTS WHERE NAME = ?");
            pstmt.setString(1, "Robert'); DROP TABLE STUDENTS; --");
            ResultSet results = pstmt.executeQuery();

            // You may want to process the results here
            while (results.next()) {
                // Process the results
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}