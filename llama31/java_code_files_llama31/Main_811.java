/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main_811 {
    public static void main(String[] stringArray) throws Exception {
        Connection connection = DriverManager.getConnection("url", "user", "password");
        String string = "username";
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ?");
        preparedStatement.setString(1, string);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
