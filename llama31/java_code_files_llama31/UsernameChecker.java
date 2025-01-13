/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsernameChecker {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        String string4 = "username_to_check";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");
            preparedStatement.setString(1, string4);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                System.out.println("Username exists");
            } else {
                System.out.println("Username does not exist");
            }
        }
        catch (Exception exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }
    }
}
