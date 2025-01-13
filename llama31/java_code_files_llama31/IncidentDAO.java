/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncidentDAO {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO incident (incident_number) VALUES (?)");
            preparedStatement.setString(1, "I?");
            preparedStatement.executeUpdate();
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
