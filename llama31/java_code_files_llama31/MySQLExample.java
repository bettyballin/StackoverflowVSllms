/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/mydatabase";
        String string2 = "myuser";
        String string3 = "mypassword";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
