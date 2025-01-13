/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/database";
        String string2 = "username";
        String string3 = "password";
        try {
            Connection connection = DriverManager.getConnection(string, string2, string3);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("product_name"));
            }
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error connecting to the database: " + sQLException.getMessage());
        }
    }
}
