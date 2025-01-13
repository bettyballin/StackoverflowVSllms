import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageUnloadHandler {
    public static void main(String[] args) {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Get the current page URL
        String currentUrl = driver.getCurrentUrl();

        // Override the onbeforeunload event
        ((JavascriptExecutor) driver).executeScript("window.onbeforeunload = null;");

        // Navigate away from the page (this would normally trigger the onbeforeunload event)
        driver.get("https://example.com");

        // If you want to test the onbeforeunload event itself, you can then restore it and trigger it manually
        ((JavascriptExecutor) driver).executeScript("window.onbeforeunload = function() { return 'Are you sure you want to leave?'; };");
        driver.get(currentUrl);

        // Close the WebDriver
        driver.quit();
    }
}