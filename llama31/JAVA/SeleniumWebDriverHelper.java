import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWebDriverHelper {
    public static void main(String[] args) {
        // Initialize the WebDriver
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(); // Replace with your preferred WebDriver

        // Navigate to the webpage
        driver.get("http://example.com"); // Replace with the URL of the webpage you want to automate

        // Find the element and send keys
        WebElement element = driver.findElement(By.xpath("//body"));
        element.sendKeys(Keys.RETURN);

        // Close the WebDriver
        driver.quit();
    }
}