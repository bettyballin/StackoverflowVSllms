/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmbeddedDBExample {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby:mydatabase;create=true");
            String string = "CREATE TABLE mytable (id INT PRIMARY KEY, mystring VARCHAR(255))";
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.execute();
            String string2 = "INSERT INTO mytable (id, mystring) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(string2);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Hello, World!");
            preparedStatement.execute();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error: " + classNotFoundException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Error: " + sQLException.getMessage());
                }
            }
        }
    }
}
