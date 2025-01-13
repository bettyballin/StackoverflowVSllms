/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_81 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        String string = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String string2 = "your_username";
        String string3 = "your_password";
        try {
            connection = DriverManager.getConnection(string, string2, string3);
        }
        catch (SQLException sQLException) {
            System.out.println("Error connecting to database: " + sQLException.getMessage());
            return;
        }
        int n = 0;
        int n2 = 100;
        while (true) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mytable OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
                preparedStatement.setInt(1, n);
                preparedStatement.setInt(2, n2);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                }
                if (resultSet.getFetchSize() < n2) break;
                n += n2;
                continue;
            }
            catch (SQLException sQLException) {
                System.out.println("Error executing query: " + sQLException.getMessage());
                continue;
            }
            finally {
                try {
                    if (connection == null) continue;
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Error closing connection: " + sQLException.getMessage());
                }
                continue;
            }
            break;
        }
    }
}
