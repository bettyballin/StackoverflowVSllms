import java.lang.String;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumTest {
    public static void main(String[] args) {
        // Set the path of your browser driver.
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Open Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to Website
        driver.get("http://www.example.com");

        // Wait for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}