/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseResultSetProcessor {
    public static void main(String[] stringArray) throws SQLException {
        Connection connection = DriverManager.getConnection("url", "user", "password");
        Statement statement = connection.createStatement();
        statement.setFetchSize(100);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
        while (resultSet.next()) {
            DatabaseResultSetProcessor.processRow(resultSet);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void processRow(ResultSet resultSet) throws SQLException {
        System.out.println(resultSet.getString(1));
    }
}
