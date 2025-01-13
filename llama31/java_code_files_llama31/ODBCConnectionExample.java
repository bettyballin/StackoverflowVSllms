/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ODBCConnectionExample {
    public static void main(String[] stringArray) {
        String string = "your_odbc_dsn";
        String string2 = "your_username";
        String string3 = "your_password";
        try {
            Connection connection = DriverManager.getConnection("jdbc:odbc:" + string, string2, string3);
            connection.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}
