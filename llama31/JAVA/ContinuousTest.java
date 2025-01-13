import java.lang.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContinuousTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        while (true) {
            try {
                // Run the test case
                driver.get("http://example.com");
                WebElement element = driver.findElement(By.id("someElement"));
                element.click();
                Thread.sleep(1000); // wait for 1 second
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}