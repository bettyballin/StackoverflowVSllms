import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EagerLoadingExample {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        // SQL query to get all users and their posts in one select statement using JOIN
        String sql = "SELECT u.id AS user_id, u.name AS user_name, p.id AS post_id, p.title AS post_title "
                   + "FROM Users u LEFT JOIN Posts p ON u.id = p.user_id";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String userName = rs.getString("user_name");
                int postId = rs.getInt("post_id");
                String postTitle = rs.getString("post_title");

                System.out.println("User ID: " + userId + ", User Name: " + userName 
                                 + ", Post ID: " + postId + ", Post Title: " + postTitle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}