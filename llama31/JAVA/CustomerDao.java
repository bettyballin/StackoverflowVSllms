import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public void queryCustomers() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(DB_URL, DB_USERNAME, DB_PASSWORD);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.queryForStream("SELECT * FROM customer", (rs, rowNum) -> {
            // Process the row
            processRow(rs);
            // Discard the row to free up memory
            try {
                rs.clearCurrentRow();
            } catch (SQLException e) {
                System.err.println("Error clearing current row: " + e.getMessage());
            }
        });
    }

    private void processRow(ResultSet rs) {
        try {
            // Implement your row processing logic here
            System.out.println(rs.getString(1)); // Example: print the first column value
        } catch (SQLException e) {
            System.err.println("Error processing row: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.queryCustomers();
    }
}