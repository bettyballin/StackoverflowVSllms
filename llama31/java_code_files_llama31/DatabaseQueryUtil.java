/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseQueryUtil {
    public static void main(String[] stringArray) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            Object[] objectArray = new String[]{"string1", "string2", "string3"};
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id IN (?)");
            preparedStatement.setArray(1, connection.createArrayOf("VARCHAR", objectArray));
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
