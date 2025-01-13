/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KillSession {
    public static void main(String[] stringArray) {
        String string = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT sid, serial# FROM V$SESSION WHERE audsid = SYS_CONTEXT('USERENV', 'SESSIONID')");
            resultSet.next();
            int n = resultSet.getInt(1);
            int n2 = resultSet.getInt(2);
            statement.execute("ALTER SYSTEM KILL SESSION '" + n + "," + n2 + "'");
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
