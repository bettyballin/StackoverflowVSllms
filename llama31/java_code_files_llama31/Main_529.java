/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.SQLException;

public class Main_529 {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            if (connection == null) {
                System.out.println("No connection object available.");
            } else if (!connection.isValid(5)) {
                System.out.println("Connection is likely closed or invalid");
            } else {
                System.out.println("Connection is valid");
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
