/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDeleter {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            int[] nArray;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TEMPORARY TABLE values_to_delete (id INT)");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO values_to_delete VALUES (?)");
            for (int n : nArray = new int[]{1, 2, 3, 4, 5}) {
                preparedStatement.setInt(1, n);
                preparedStatement.executeUpdate();
            }
            preparedStatement = connection.prepareStatement("DELETE FROM foo WHERE id IN (SELECT id FROM values_to_delete)");
            preparedStatement.executeUpdate();
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
