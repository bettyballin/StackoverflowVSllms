/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_326 {
    public static void main(String[] stringArray) {
        try (Connection connection = DriverManager.getConnection("url", "user", "password");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("query");){
            while (resultSet.next()) {
            }
        }
        catch (SQLException sQLException) {
            System.out.println("An error occurred: " + sQLException.getMessage());
        }
    }
}
