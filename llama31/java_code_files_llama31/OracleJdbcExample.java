/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJdbcExample {
    public static void main(String[] stringArray) {
        String string = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String string2 = "your_username";
        String string3 = "your_password";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection(string, string2, string3);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + ", " + resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error: Oracle JDBC driver not found.");
        }
    }
}
