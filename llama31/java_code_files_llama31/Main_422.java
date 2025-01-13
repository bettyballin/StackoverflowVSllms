/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_422 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        String string = "your_database_url";
        String string2 = "your_username";
        String string3 = "your_password";
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(string, string2, string3);
            String string4 = "SELECT my_seq.nextval FROM dual";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(string4);
            if (resultSet.next()) {
                int n = resultSet.getInt(1);
                String string5 = "INSERT INTO my_table (id, /* other columns */) VALUES (?, /* other values */)";
                PreparedStatement preparedStatement = connection.prepareStatement(string5);
                preparedStatement.setInt(1, n);
                preparedStatement.executeUpdate();
                System.out.println("Inserted successfully with ID: " + n);
            } else {
                System.out.println("Failed to retrieve the next sequence value.");
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Oracle JDBC Driver not found.");
        }
        catch (SQLException sQLException) {
            System.out.println("SQL Exception occurred: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Failed to close the database connection.");
                }
            }
        }
    }
}
