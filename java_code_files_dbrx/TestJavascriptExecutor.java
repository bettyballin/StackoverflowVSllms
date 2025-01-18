import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class TestJavascriptExecutor {
    public static void main(String[] args) {
        // Instantiate your WebDriver and navigate to your app's landing page
        WebDriver driver = new FirefoxDriver();
        driver.get("https://example.com");

        // Now that you have navigated, execute your JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return window.onbeforeunload == true"); // To check if onbeforeunload is registered as an EventListener and also to prevent it from being fired.

        // Close the driver
        driver.quit();
    }
}