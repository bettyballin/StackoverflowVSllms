import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataStorageManager {
    public static void main(String[] args) {
        // Assuming you have a database connection established
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String dbUser = "your_username";
        String dbPassword = "your_password";

        String htmlContent = "<html><body>Hello World!</body></html>";
        byte[] imageBytes = "Image bytes".getBytes();

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            // Storing text data in a database
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO articles (content) VALUES (?)");
            stmt.setString(1, htmlContent);
            stmt.executeUpdate();

            // Storing images on disk (using Java NIO)
            Path imagePath = Paths.get("images", "image.jpg");
            Files.write(imagePath, imageBytes);
        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}