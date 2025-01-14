import java.lang.String;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerUpdater {

    private Connection connection;

    public void updateCustomerBalance(int customerId, BigDecimal amount) {
        String sql = "UPDATE Customers SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, amount);
            pstmt.setInt(2, customerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
    }
}