/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionTest {
    public static void main(String[] stringArray) {
        String string = "jdbc:oracle:thin:@//<hostname>:<port>/<SID>";
        String string2 = "<username>";
        String string3 = "<password>";
        try {
            Connection connection = DriverManager.getConnection(string, string2, string3);
            System.out.println("Connected to Oracle database!");
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error connecting to Oracle database: " + sQLException.getMessage());
        }
    }
}
