import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebInteraction {
    public static void main(String[] args) {
        // Set up the path of ChromeDriver (compatible with Chrome browser version)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Create a new instance for ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to website
            driver.get("https://www.website.com/form");

            // Find input elements by name and send text
            driver.findElement(By.name("firstName")).sendKeys("John");
            driver.findElement(By.name("lastName")).sendKeys("Doe");

            // Submit the form
            driver.findElement(By.name("submitButton")).click();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            // Quit the driver and close the browser
            driver.quit();
        }
    }
}