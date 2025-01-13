import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigExample {
    public static void main(String[] args) throws Exception {
        // Load the properties file
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("config.properties")));

        // Get the user name and password from the properties file
        String userName = properties.getProperty("username");
        String password = properties.getProperty("password");

        // Use the user name and password
        System.out.println("User name: " + userName);
        System.out.println("Password: " + password);
    }
}