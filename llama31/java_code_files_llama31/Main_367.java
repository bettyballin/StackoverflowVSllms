/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_367 {
    public static void main(String[] stringArray) {
        String string = "jdbc:postgresql://localhost:5432/mydatabase";
        String string2 = "myusername";
        String string3 = "mypassword";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(g.id) FROM \"Group\" g");){
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        }
        catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
    }
}
