import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyController_8_8 {

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private String SQL;

    public MyController_8() {
        // Initialize the SimpleJdbcTemplate and SQL query string
        // For this example, we'll assume they're initialized here
        // In a real application, you'd likely want to inject these or load them from a properties file
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(null); // Replace with your data source
        this.SQL = "SELECT * FROM your_table"; // Replace with your SQL query
    }

    @GetMapping("/data")
    public String getData() {
        try {
            simpleJdbcTemplate.queryForInt(SQL, null);
        } catch (RuntimeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataAccessException) {
                DataAccessException dae = (DataAccessException) cause;
                // Handle the DataAccessException and return a meaningful error message
                return "Database error: " + dae.getMessage();
            } else {
                // Handle other RuntimeExceptions
                return "Internal server error: " + e.getMessage();
            }
        }
        return "No error occurred"; // Return a message when no error occurs
    }

    public static void main(String[] args) {
        // Create an instance of the controller to test it
        MyController_8 controller = new MyController_8();
        System.out.println(controller.getData());
    }
}