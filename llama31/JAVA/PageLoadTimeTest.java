import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PageLoadTimeTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://example.com");
        long startTime = System.currentTimeMillis();
        WebElement element = driver.findElement(By.tagName("body"));
        long endTime = System.currentTimeMillis();
        System.out.println("Page load time: " + (endTime - startTime) + "ms");
        driver.quit();
    }
}