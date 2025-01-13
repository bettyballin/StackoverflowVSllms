/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_305 {
    public static void main(String[] stringArray) throws SQLException {
        Object object;
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
        while (resultSet.next()) {
            object = resultSet.getString(1);
            String string = resultSet.getString(2);
        }
        resultSet.beforeFirst();
        object = resultSet.getMetaData();
        int n = object.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= n; ++i) {
                String string = object.getColumnName(i);
                String string2 = resultSet.getString(i);
            }
        }
        connection.close();
    }
}
