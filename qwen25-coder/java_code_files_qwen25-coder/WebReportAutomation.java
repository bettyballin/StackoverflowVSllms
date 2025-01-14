import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebReportAutomation {
    public static void main(String[] args) {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://example.com/login");

            // Find username and password input fields, enter your credentials, and submit form
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));

            usernameField.sendKeys("yourUsername");
            passwordField.sendKeys("yourPassword");

            passwordField.submit(); // Assuming that pressing Enter submits the form

            // Wait for navigation page to load (you may want a more intelligent wait)
            Thread.sleep(5000);

            // Select form elements and submit them
            WebElement reportSelection = driver.findElement(By.id("reportType"));
            reportSelection.sendKeys("desiredReport");

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser window
            driver.quit();
        }
    }
}