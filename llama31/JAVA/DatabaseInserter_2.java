import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInserter_2_2 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydatabase"; // replace with your database URL
        String username = "myuser"; // replace with your database username
        String password = "mypassword"; // replace with your database password
        int myCountValue = 10; // replace with your count value

        try {
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO mytable (COUNT) VALUES (?)");
            pstmt.setInt(1, myCountValue);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}