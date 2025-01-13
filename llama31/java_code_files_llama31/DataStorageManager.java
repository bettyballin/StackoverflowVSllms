/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataStorageManager {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        String string4 = "<html><body>Hello World!</body></html>";
        byte[] byArray = "Image bytes".getBytes();
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO articles (content) VALUES (?)");
            preparedStatement.setString(1, string4);
            preparedStatement.executeUpdate();
            Path path = Paths.get("images", "image.jpg");
            Files.write(path, byArray, new OpenOption[0]);
        }
        catch (IOException | SQLException exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
