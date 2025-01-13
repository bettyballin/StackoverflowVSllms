/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBChecker {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/mydb";
        String string2 = "myuser";
        String string3 = "mypassword";
        try {
            Connection connection = DriverManager.getConnection(string, string2, string3);
            if (connection != null) {
                System.out.println("Database exists and connection is successful!");
                connection.close();
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Database does not exist or connection failed: " + sQLException.getMessage());
        }
    }
}
