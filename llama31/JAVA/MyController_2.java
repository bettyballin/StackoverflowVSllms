import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController_2_2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/data")
    public String getData(Model model) {
        // Connect to database using ODBC
        jdbcTemplate.setDataSource(dataSource());
        // Retrieve data from database
        List<?> data = jdbcTemplate.queryForList("SELECT * FROM your_table");
        // Display data in view
        model.addAttribute("data", data);
        return "data";
    }

    private DriverManagerDataSource dataSource() {
        // Configure ODBC data source
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("your_driver_class_name");
        dataSource.setUrl("your_url");
        dataSource.setUsername("your_user_name");
        dataSource.setPassword("your_password");
        return dataSource;
    }

    public static void main(String[] args) {
        // You can't run a Spring Web application from a main method like this.
        // You need to use a servlet container like Tomcat or Jetty.
        // For a simple example, consider using Spring Boot.
    }
}