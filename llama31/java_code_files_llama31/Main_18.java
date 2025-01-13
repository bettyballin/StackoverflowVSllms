/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_18 {
    public static String sanitize(String string) {
        string = string.trim();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "username", "password");
            string = connection.nativeSQL(string);
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_18.sanitize(" test input "));
    }
}
