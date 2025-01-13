/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageInserter {
    public static void main(String[] stringArray) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            String string = "INSERT INTO messages (id, title, body, `to`) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "Test Message");
            preparedStatement.setString(3, "This is a test message...");
            preparedStatement.setString(4, "an email");
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
