/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSessionChecker {
    public static void main(String[] stringArray) {
        String string = "SELECT * FROM users WHERE TIMESTAMPDIFF(MINUTE, login_time, NOW()) <= ?";
        String string2 = "jdbc:mysql://localhost:3306/your_database";
        String string3 = "your_username";
        String string4 = "your_password";
        try (Connection connection = DriverManager.getConnection(string2, string3, string4);
             PreparedStatement preparedStatement = connection.prepareStatement(string);){
            preparedStatement.setInt(1, 10);
            try (ResultSet resultSet = preparedStatement.executeQuery();){
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
