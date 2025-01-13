/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionManager {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            Statement statement = connection.createStatement();
            if (statement != null) {
                statement.close();
            }
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }
}
