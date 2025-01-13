/*
 * Decompiled with CFR 0.152.
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCallableStatementInvoker {
    public static void main(String[] stringArray) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            CallableStatement callableStatement = connection.prepareCall("CALL testEM(?)");
            callableStatement.setString(1, "your_input_value");
            callableStatement.execute();
            callableStatement.close();
            connection.close();
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error loading JDBC driver: " + classNotFoundException.getMessage());
        }
        catch (SQLException sQLException) {
            System.out.println("Error executing stored procedure: " + sQLException.getMessage());
        }
    }
}
