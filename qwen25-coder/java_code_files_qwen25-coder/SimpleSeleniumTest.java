import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumTest {
    public static void main(String[] args) {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize a Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to a web page
            driver.get("https://www.example.com");

            // Get the title of the page and compare it with expected value
            String pageTitle = driver.getTitle();
            if (pageTitle.equals("Example Domain")) {
                System.out.println("Test Passed: Correct Page Title!");
            } else {
                System.out.println("Test Failed: Incorrect Page Title.");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}