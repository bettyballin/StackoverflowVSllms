/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseDAO {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        int n = 1;
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO purchases (productid, price) VALUES (?, (SELECT price FROM products WHERE id = ?))");
            preparedStatement.setInt(1, n);
            preparedStatement.setInt(2, n);
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
