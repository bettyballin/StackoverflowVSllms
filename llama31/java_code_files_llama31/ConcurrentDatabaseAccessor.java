/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConcurrentDatabaseAccessor {
    public static void main(String[] stringArray) {
        try {
            Connection connection = DriverManager.getConnection("url", "user", "password");
            Connection connection2 = DriverManager.getConnection("url", "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement("query1");
            PreparedStatement preparedStatement2 = connection2.prepareStatement("query2");
            preparedStatement.executeQuery();
            preparedStatement2.executeQuery();
            preparedStatement.close();
            preparedStatement2.close();
            connection.close();
            connection2.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error accessing database: " + sQLException.getMessage());
        }
    }
}
