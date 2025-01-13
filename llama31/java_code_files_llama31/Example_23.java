/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example_23 {
    public static void main(String[] stringArray) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        Integer n = 5;
        Integer n2 = 10;
        String string = "SELECT z FROM your_table WHERE x > ?";
        String string2 = "SELECT z FROM your_table WHERE x <= ?";
        if (n != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setObject(1, n2);
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(string2);
            preparedStatement.setObject(1, n2);
        }
        String string3 = "SELECT z FROM your_table WHERE x > ? JOIN a ON b";
        String string4 = "SELECT z FROM your_table WHERE x <= ? JOIN a ON b";
    }
}
