/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateRangeQuery {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            Date date = new Date(System.currentTimeMillis());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM group_table WHERE ? BETWEEN ArrivalDate AND DepartureDate");
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error loading database driver: " + classNotFoundException.getMessage());
        }
        catch (SQLException sQLException) {
            System.out.println("Error accessing database: " + sQLException.getMessage());
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException sQLException) {
                System.out.println("Error closing database connection: " + sQLException.getMessage());
            }
        }
    }
}
