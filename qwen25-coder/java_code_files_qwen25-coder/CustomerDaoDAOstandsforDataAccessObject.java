import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoDAOstandsforDataAccessObject {
    private Connection connection;

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (name, address, telephone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getAddress());
            pstmt.setString(3, customer.getTelephone());
            pstmt.setString(4, customer.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
    }

    public static void main(String[] args) {
    }
}

class Customer {
    public String getName() { return null; }
    public String getAddress() { return null; }
    public String getTelephone() { return null; }
    public String getEmail() { return null; }
}