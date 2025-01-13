/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLPaginator {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/database_name";
        String string2 = "username";
        String string3 = "password";
        int n = 10;
        int n2 = 0;
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM table_name LIMIT ? OFFSET ?");
            preparedStatement.setInt(1, n);
            preparedStatement.setInt(2, n2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            }
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
