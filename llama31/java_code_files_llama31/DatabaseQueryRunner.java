/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryRunner {
    public static void main(String[] stringArray) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mytable WHERE id = ?");
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error executing query: " + sQLException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error loading JDBC driver: " + classNotFoundException.getMessage());
        }
    }
}
