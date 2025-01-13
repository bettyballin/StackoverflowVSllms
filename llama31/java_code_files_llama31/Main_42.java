/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_42 {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        String string4 = "SELECT fname, lname FROM people WHERE isValid = 1 AND lname LIKE '%test%'";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error loading MySQL JDBC driver: " + classNotFoundException.getMessage());
            return;
        }
        try (Connection connection = DriverManager.getConnection(string, string2, string3);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(string4);){
            while (resultSet.next()) {
                System.out.println(resultSet.getString("fname") + " " + resultSet.getString("lname"));
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error executing query: " + sQLException.getMessage());
        }
    }
}
