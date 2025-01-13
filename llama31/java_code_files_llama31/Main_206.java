/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_206 {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            Statement statement = connection.createStatement();
            statement.execute("LOCK TABLE MYTABLE IN EXCLUSIVE MODE");
            statement.execute("COMMIT");
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Error closing connection: " + sQLException.getMessage());
                }
            }
        }
    }
}
