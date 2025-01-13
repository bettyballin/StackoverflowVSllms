import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;

public class CustomerOrderInsertExample {
    private JdbcTemplate jdbcTemplate;

    public CustomerOrderInsertExample() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Replace with your database driver
        dataSource.setUrl("jdbc:mysql://localhost:3306/your_database"); // Replace with your database URL
        dataSource.setUsername("your_username"); // Replace with your database username
        dataSource.setPassword("your_password"); // Replace with your database password

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertCustomerAndOrders() {
        // Insert customer
        String customerSql = "INSERT INTO CUSTOMER (NAME, EMAIL) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement pstmt = conn.prepareStatement(customerSql, new String[] {"ID"});
                pstmt.setString(1, "John Doe");
                pstmt.setString(2, "john.doe@example.com");
                return pstmt;
            }
        }, keyHolder);

        Long customerId = keyHolder.getKey().longValue();

        // Insert orders
        String orderSql = "INSERT INTO ORDERS (CUSTOMER_ID, ORDER_DATE, TOTAL) VALUES (?, ?, ?)";
        for (int i = 0; i < 5; i++) {
            jdbcTemplate.update(orderSql, customerId, new Date(System.currentTimeMillis()), 100.00);
        }
    }

    public static void main(String[] args) {
        CustomerOrderInsertExample example = new CustomerOrderInsertExample();
        example.insertCustomerAndOrders();
    }
}