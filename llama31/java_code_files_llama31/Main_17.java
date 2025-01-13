/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_17 {
    public static String sanitize(String string) {
        string = string.trim();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ?");
            preparedStatement.setString(1, string);
            string = preparedStatement.toString().replaceFirst(".*\\(.*\\)", "");
        }
        catch (SQLException sQLException) {
            System.out.println("An error occurred: " + sQLException.getMessage());
        }
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_17.sanitize("  test  "));
    }
}
