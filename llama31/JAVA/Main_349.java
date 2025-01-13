import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main_349 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("db.properties"));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            System.out.println("DB URL: " + dbUrl);
            System.out.println("DB Username: " + dbUsername);
            System.out.println("DB Password: " + dbPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}