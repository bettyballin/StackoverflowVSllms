import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertScriptExample {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the page
        driver.get("http://example.com");

        // Execute JavaScript to insert a script into the head
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "var script = document.createElement('script');" +
            "script.type = 'text/javascript';" +
            "script.text = \"console.log('This is a custom script!');\";" +
            "document.head.appendChild(script);"
        );

        // Optionally, change IDs of elements
        js.executeScript("document.getElementById('oldId').id = 'newId';");

        // Close the browser
        driver.quit();
    }
}