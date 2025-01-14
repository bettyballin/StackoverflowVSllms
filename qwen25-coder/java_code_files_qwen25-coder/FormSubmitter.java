import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormSubmitter {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the target webpage
            driver.get("https://example.com/login");  // Replace with your provider's login URL

            // Locate and fill out form elements
            WebElement usernameField = driver.findElement(By.id("username"));  // Adjust selectors as needed
            usernameField.sendKeys("your-email@example.com");

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("your-password");

            // Submit the login form
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            Thread.sleep(5000);  // Wait for the page to load after submission

            // Navigate to and fill out your text message form
            driver.get("https://example.com/send-message");  // Replace with your provider's send message URL

            WebElement recipientField = driver.findElement(By.id("recipient"));
            recipientField.sendKeys("+1234567890");

            WebElement messageField = driver.findElement(By.id("message"));
            messageField.sendKeys("Your text message here.");

            // Submit the message
            WebElement sendMessageButton = driver.findElement(By.id("send"));
            sendMessageButton.click();

            Thread.sleep(5000);  // Wait for the message to be sent

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}