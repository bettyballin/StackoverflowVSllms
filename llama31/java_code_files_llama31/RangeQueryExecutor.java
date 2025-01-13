/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RangeQueryExecutor {
    public static void main(String[] stringArray) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM your_table WHERE left_bound > ? AND right_bound < ?");
        int n = 10;
        int n2 = 20;
        preparedStatement.setInt(1, n);
        preparedStatement.setInt(2, n2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
