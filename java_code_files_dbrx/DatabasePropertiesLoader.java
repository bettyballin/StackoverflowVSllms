import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DatabasePropertiesLoader {

    Properties dbProps = new Properties();

    public DatabasePropertiesLoader() {
        try (FileInputStream fis = new FileInputStream("path/to/db_config")) {
            dbProps.load(fis);
        } catch (IOException e) {
            // handle exception if config file not found etc.
            // Load defaults
            try (FileInputStream defFis = new FileInputStream("classpath:default_config")) {
                Properties defaultProps = new Properties();
                defaultProps.load(defFis);
                dbProps = defaultProps;
            } catch (IOException e2) {
                // handle exception if default config file not found etc.
            }
        }
    }

    public static void main(String[] args) {
    }
}