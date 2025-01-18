import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysExample {
    public static void main(String[] args) {
        // Set the path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.example.com");

        // Set the driver in the SeleniumHelper class
        SeleniumHelper.driver = driver;

        // Use the SendKeys method
        SeleniumHelper.SendKeys("your_element", Keys.RETURN);

        // Close the driver
        driver.quit();
    }
}

class SeleniumHelper {
    public static WebDriver driver;

    public static void SendKeys(String elementId, Keys key) {
        // Find the element by its ID
        WebElement element = driver.findElement(By.id(elementId));
        // Send the specified key to the element
        element.sendKeys(key);
    }
}