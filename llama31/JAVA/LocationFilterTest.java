import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocationFilterTest {
    public static void main(String[] args) {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://example.com");

        // Perform the assertions
        WebElement locationLabel = driver.findElement(By.xpath("//div[@class='filter-label' and text()='Location']"));
        Assert.assertTrue(locationLabel.isDisplayed());

        WebElement titleSlave = driver.findElement(By.xpath("//div[@class='as-slave' and .//div[@class='filter-label' and text()='Title']]"));
        Assert.assertFalse(titleSlave.isDisplayed());

        // Close the WebDriver
        driver.quit();
    }
}