/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmailStorageExample {
    public static void main(String[] stringArray) {
        String string = "example@example.com";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (email) VALUES (?)");){
            preparedStatement.setString(1, string);
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
