/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserPermissionsFetcher {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error loading JDBC driver: " + classNotFoundException.getMessage());
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
        }
        catch (Exception exception) {
            System.out.println("Error establishing database connection: " + exception.getMessage());
            return;
        }
        int n = 1;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT permissions FROM acl WHERE user_id = ?");){
            preparedStatement.setInt(1, n);
            try (ResultSet resultSet = preparedStatement.executeQuery();){
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("permissions"));
                }
            }
        }
        catch (Exception exception) {
            System.out.println("Error executing query: " + exception.getMessage());
        }
        finally {
            try {
                connection.close();
            }
            catch (Exception exception) {
                System.out.println("Error closing database connection: " + exception.getMessage());
            }
        }
    }
}
