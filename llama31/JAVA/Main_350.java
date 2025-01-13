import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main_350 {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("/etc/myapp/db.properties"));
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
            return;
        }

        String dbUrl = props.getProperty("db.url");
        String dbUsername = props.getProperty("db.username");
        String dbPassword = props.getProperty("db.password");

        // Use these values to establish a database connection
        System.out.println("Database URL: " + dbUrl);
        System.out.println("Database Username: " + dbUsername);
        System.out.println("Database Password: " + dbPassword);
    }
}