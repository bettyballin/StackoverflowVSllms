import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class CssSelectorPrinter {
    public static void main(String[] args) {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://www.example.com");

        List<WebElement> allElements = driver.findElements(By.xpath("//*"));

        for (WebElement element : allElements) {
            String cssSelector = element.getCssSelector();
            System.out.println(cssSelector);
        }

        // Close the WebDriver
        driver.quit();
    }
}