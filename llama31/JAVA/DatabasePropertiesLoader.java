import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabasePropertiesLoader {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("db.properties"));
            String dbUser = props.getProperty("username");
            String dbPassword = props.getProperty("password");
            // You may want to use dbUser and dbPassword here
            System.out.println("Database User: " + dbUser);
            System.out.println("Database Password: " + dbPassword);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }
}