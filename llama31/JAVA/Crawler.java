import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Crawler {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://example.com");
        // Save the page source to a file
        String pageSource = driver.getPageSource();
        // ...
        driver.quit();
    }
}