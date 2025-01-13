/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableDataRetriever {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM table WHERE RTRIM(PRT_STATUS) = ?");
            preparedStatement.setString(1, "ONT");
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
