/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_149 {
    public static void main(String[] stringArray) throws SQLException {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        Connection connection = DriverManager.getConnection(string, string2, string3);
        String string4 = "your_bind_value";
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(col1), f_result FROM (   SELECT col1, f(?, col2) AS f_result   FROM t ) AS subquery GROUP BY f_result");
        preparedStatement.setString(1, string4);
        preparedStatement.close();
        connection.close();
    }
}
