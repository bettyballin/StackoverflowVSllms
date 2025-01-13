/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobRetriever {
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "myuser", "mypassword");
        }
        catch (SQLException sQLException) {
            System.out.println("Error establishing connection: " + sQLException.getMessage());
            return;
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT contents FROM documents WHERE id = ?");){
            preparedStatement.setInt(1, 1);
            try (ResultSet resultSet = preparedStatement.executeQuery();){
                if (resultSet.next()) {
                    byte[] byArray = resultSet.getBytes(1);
                }
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error retrieving blob: " + sQLException.getMessage());
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException sQLException) {
                System.out.println("Error closing connection: " + sQLException.getMessage());
            }
        }
    }
}
