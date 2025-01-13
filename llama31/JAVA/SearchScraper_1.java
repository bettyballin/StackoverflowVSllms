import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchScraper_1_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/search");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("your_query");
        searchBox.submit();
        // Wait for the results to load
        WebElement results = driver.findElement(By.cssSelector(".results"));
        System.out.println(results.getText());
        driver.quit();
    }
}