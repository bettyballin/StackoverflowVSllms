import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SlaveElementVisibilityChecker {
    public static void main(String[] args) {
        // Set the path to your chromedriver executable if necessary
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver (Assuming ChromeDriver is set up properly)
        WebDriver driver = new ChromeDriver();

        // Navigate to the page (replace with the actual URL)
        driver.get("http://example.com");

        // XPath for finding the slave div of Title
        String xPath = "//div[@class='filter-label' and text()='Title']/following-sibling::div[contains(@class, 'as-slave')]";

        // Locate the element
        WebElement titleSlaveDiv = driver.findElement(By.xpath(xPath));

        // Check if the element is not visible
        if (!titleSlaveDiv.isDisplayed()) {
            System.out.println("The 'Title' with class 'as-slave' is not visible.");
        } else {
            System.out.println("The 'Title' with class 'as-slave' is visible.");
        }

        // Close the driver
        driver.quit();
    }
}