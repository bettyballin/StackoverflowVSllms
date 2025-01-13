/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecureUserQuery {
    public static void main(String[] stringArray) {
        String string = "SELECT * FROM users WHERE username = ? AND password = ?";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection("your_database_url", "your_database_username", "your_database_password");
             PreparedStatement preparedStatement = connection.prepareStatement(string);){
            preparedStatement.setString(1, string2);
            preparedStatement.setString(2, string3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error executing query: " + sQLException.getMessage());
        }
    }
}
