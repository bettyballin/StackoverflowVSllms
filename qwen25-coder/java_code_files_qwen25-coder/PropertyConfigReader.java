import java.lang.String;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PropertyConfigReader {
    // Reading from properties file
    Properties prop = new Properties();
    WebDriver driver;

    {
        try {
            FileInputStream input = new FileInputStream("config.properties");
            prop.load(input);
            String selector = prop.getProperty("googleSearchBox");
            driver.findElement(By.cssSelector(selector));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}