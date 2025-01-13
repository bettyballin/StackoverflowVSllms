/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/mydatabase";
        String string2 = "myuser";
        String string3 = "mypassword";
        try {
            Connection connection = DriverManager.getConnection(string, string2, string3);
            System.out.println("Connected to MySQL database!");
        }
        catch (Exception exception) {
            System.out.println("Error connecting to MySQL database: " + exception.getMessage());
        }
    }
}
