/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VulnerableDatabaseAccessor {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        String string4 = "example_username";
        String string5 = "example_password";
        try {
            Connection connection = DriverManager.getConnection(string, string2, string3);
            Statement statement = connection.createStatement();
            String string6 = "SELECT * FROM users WHERE username = '" + string4 + "' AND password = '" + string5 + "'";
            ResultSet resultSet = statement.executeQuery(string6);
            while (resultSet.next()) {
                System.out.println("User found");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("An error occurred while accessing the database:");
            sQLException.printStackTrace();
        }
    }
}
