/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderInserter {
    public static void main(String[] stringArray) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (amount, tax, total) VALUES (?, ?, ?)");
            preparedStatement.setBigDecimal(1, new BigDecimal("100.00"));
            preparedStatement.setBigDecimal(2, new BigDecimal("8.00"));
            preparedStatement.setBigDecimal(3, new BigDecimal("108.00"));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
