import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadTimeCalculator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://example.com"; // replace with your website URL

        // Measure page loading time
        long startTime = System.currentTimeMillis();
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 10); // wait up to 10 seconds
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        long endTime = System.currentTimeMillis();

        long pageLoadTime = endTime - startTime;
        System.out.println("Page Load Time: " + pageLoadTime + " milliseconds");

        driver.quit();
    }
}