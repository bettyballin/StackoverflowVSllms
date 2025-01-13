/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SecureDatabaseConnection {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/mydatabase";
        String string2 = "myuser";
        String string3 = "mypassword";
        Properties properties = new Properties();
        properties.setProperty("user", string2);
        properties.setProperty("password", string3);
        try (Connection connection = DriverManager.getConnection(string, properties);){
            System.out.println("Connected to the database!");
        }
        catch (SQLException sQLException) {
            System.out.println("Error connecting to the database: " + sQLException.getMessage());
        }
    }
}
