import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertCustomerWithOrders(String customerName, String[] orderDetails) {
        // Get the next value from the sequence for customer ID
        Integer customerId = jdbcTemplate.queryForObject("SELECT customer_seq.NEXTVAL FROM dual", Integer.class);

        // Insert into CUSTOMER table
        String sqlInsertCustomer = "INSERT INTO CUSTOMER (ID, NAME) VALUES (?, ?)";
        jdbcTemplate.update(sqlInsertCustomer, customerId, customerName);

        // Insert into ORDERS table for each order detail
        String sqlInsertOrder = "INSERT INTO ORDERS (ID, CUSTOMER_ID, ORDER_DETAILS) VALUES (order_seq.NEXTVAL, ?, ?)";
        for (String details : orderDetails) {
            jdbcTemplate.update(sqlInsertOrder, customerId, details);
        }
    }

    public static void main(String[] args) {
        // You can test the insertCustomerWithOrders method here
    }
}