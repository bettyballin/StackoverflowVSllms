/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_7 {
    public static String sanitize(String string) {
        return string.trim();
    }

    public static void main(String[] stringArray) {
        String string = "example input";
        String string2 = Main_7.sanitize(string);
        String string3 = "jdbc:mysql://localhost:3306/mydb";
        String string4 = "myuser";
        String string5 = "mypassword";
        try (Connection connection = DriverManager.getConnection(string3, string4, string5);){
            String string6 = "SELECT * FROM mytable WHERE mycolumn = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(string6);
            preparedStatement.setString(1, string2);
            preparedStatement.executeQuery();
        }
        catch (SQLException sQLException) {
            System.err.println(sQLException.getMessage());
        }
    }
}
