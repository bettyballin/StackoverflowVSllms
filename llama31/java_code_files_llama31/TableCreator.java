/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreator {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:mem:test");
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE SomeTable(id INTEGER IDENTITY, text LONGVARCHAR)");
            preparedStatement.executeUpdate();
            System.out.println("Table created successfully");
        }
        catch (SQLException sQLException) {
            System.out.println("Error creating table: " + sQLException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error loading JDBC driver: " + classNotFoundException.getMessage());
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
