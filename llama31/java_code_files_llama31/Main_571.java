/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main_571 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        LocalDate localDate = LocalDate.now();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String string = "jdbc:mysql://localhost:3306/your_database";
            String string2 = "your_username";
            String string3 = "your_password";
            connection = DriverManager.getConnection(string, string2, string3);
            Date date = Date.valueOf(localDate);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mytable (date) VALUES (?)");
            preparedStatement.setDate(1, date);
            preparedStatement.executeUpdate();
            System.out.println("Date inserted into the database successfully.");
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("MySQL JDBC driver not found: " + classNotFoundException.getMessage());
        }
        catch (SQLException sQLException) {
            System.out.println("SQL Error: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Failed to close the database connection: " + sQLException.getMessage());
                }
            }
        }
    }
}
