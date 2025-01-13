/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BulkTransfer {
    public static void main(String[] stringArray) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@db1", "user1", "password1");
        Connection connection2 = DriverManager.getConnection("jdbc:oracle:thin:@db2", "user2", "password2");
        Statement statement = connection.createStatement();
        Statement statement2 = connection2.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT column1, column2 FROM TABLE_A WHERE filter_condition");
        PreparedStatement preparedStatement = connection2.prepareStatement("INSERT INTO TABLE_A (column1, column2) VALUES (?, ?)");
        while (resultSet.next()) {
            preparedStatement.setString(1, resultSet.getString(1));
            preparedStatement.setString(2, resultSet.getString(2));
            preparedStatement.executeUpdate();
        }
        resultSet.close();
        preparedStatement.close();
        statement.close();
        statement2.close();
        connection.close();
        connection2.close();
    }
}
