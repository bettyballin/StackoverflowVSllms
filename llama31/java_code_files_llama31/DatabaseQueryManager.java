/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class DatabaseQueryManager {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("jdbc.driver.class.Name");
            connection = DriverManager.getConnection("jdbc:database:connection:string");
            statement = connection.prepareStatement("SELECT * FROM my_table");
            statement.executeQuery();
            statement.cancel();
            SQLWarning sQLWarning = statement.getWarnings();
            if (sQLWarning != null) {
                System.out.println("Query was canceled: " + sQLWarning.getMessage());
            }
        }
        catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException sQLException) {
                System.out.println("Error closing connections: " + sQLException.getMessage());
            }
        }
    }
}
