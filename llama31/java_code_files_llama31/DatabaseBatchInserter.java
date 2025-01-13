/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseBatchInserter {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DST_Table (c1, c5, c6) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, 2);
            preparedStatement.setInt(3, 3);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException sQLException) {
                System.out.println("Error closing connection: " + sQLException.getMessage());
            }
        }
    }
}
