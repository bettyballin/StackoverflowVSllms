import org.openqa.selenium.WebDriver;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OnBeforeUnloadTest {
    public static void main(String[] args) {
        // Set the path to your Chrome WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Configure Chrome to automatically accept or dismiss alerts
        ChromeOptions options = new ChromeOptions();
        // Accept onbeforeunload confirm dialog
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        
        // Create a new instance of the ChromeDriver with the specified options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to your web page
            driver.get("http://example.com");

            // Perform actions that would normally trigger onbeforeunload
        
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}