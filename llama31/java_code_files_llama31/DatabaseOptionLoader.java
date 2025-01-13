/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOptionLoader {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/mydatabase";
        String string2 = "myuser";
        String string3 = "mypassword";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM options");){
            while (resultSet.next()) {
                String string4 = resultSet.getString("name");
                String string5 = resultSet.getString("value");
                System.out.println("Name: " + string4 + ", Value: " + string5);
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error connecting to the database: " + sQLException.getMessage());
        }
    }
}
