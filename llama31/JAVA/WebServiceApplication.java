import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
@RestController
public class WebServiceApplication {

    // MySQL connection settings
    private static final String DB_URL = "jdbc:mysql://your_host:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    @GetMapping("/data")
    public String getData() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM your_table")) {

            StringBuilder data = new StringBuilder();
            while (rs.next()) {
                data.append(rs.getString(1)).append(",");
            }
            return data.toString();
        } catch (Exception e) {
            return "Error fetching data: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }
}