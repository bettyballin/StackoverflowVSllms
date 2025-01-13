import java.io.File;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageUploader_3_3 {
    public static void main(String[] args) {
        // Create a Connection object and a PreparedStatement
        try (Connection connection = /* Initialize your connection object here */) {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO images (image_data) VALUES (?)");
            File imageFile = new File("path/to/image.jpg");
            byte[] imageData = Files.readAllBytes(imageFile.toPath());
            stmt.setBlob(1, new ByteArrayInputStream(imageData));
            stmt.executeUpdate();
        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}