/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_403 {
    public static void main(String[] stringArray) {
        String string = "jdbc:sqlserver://localhost";
        String string2 = "your_username";
        String string3 = "your_password";
        try {
            Connection connection = DriverManager.getConnection(string, string2, string3);
            System.out.println("Connected to the database successfully!");
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Failed to connect to the database: " + sQLException.getMessage());
        }
    }
}
