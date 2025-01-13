/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SemaphoreExample {
    public static void main(String[] stringArray) {
        try (Connection connection = DriverManager.getConnection("url", "user", "password");){
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MY_SEMAPHORE SET LOCKED = 1 WHERE ID = 1 AND LOCKED = 0");
            int n = preparedStatement.executeUpdate();
            if (n == 1) {
                System.out.println("Lock acquired, performing updates");
            } else {
                System.out.println("Lock is already held by another node");
            }
            preparedStatement = connection.prepareStatement("UPDATE MY_SEMAPHORE SET LOCKED = 0 WHERE ID = 1");
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
