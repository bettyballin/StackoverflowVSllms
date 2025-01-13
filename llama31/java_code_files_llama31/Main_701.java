/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_701 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(string, string2, string3);
            statement = connection.createStatement();
            String string4 = "SELECT * FROM your_table";
            resultSet = statement.executeQuery(string4);
            while (resultSet.next()) {
                int n = resultSet.getInt("id");
                String string5 = resultSet.getString("name");
                System.out.println("ID: " + n + ", Name: " + string5);
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("MySQL JDBC Driver not found!");
            classNotFoundException.printStackTrace();
        }
        catch (SQLException sQLException) {
            System.out.println("Error while accessing the database:");
            sQLException.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Failed to close the result set:");
                    sQLException.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Failed to close the statement:");
                    sQLException.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Failed to close the connection:");
                    sQLException.printStackTrace();
                }
            }
        }
    }
}
