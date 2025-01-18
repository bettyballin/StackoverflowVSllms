import java.io.IOException;
import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import org.openqa.selenium.*;

public class Scraper {
    public static void main(String... args) throws InterruptedException, IOException {
        JBrowserDriver driver = new JBrowserDriver();
        try {
            WebElement emailField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.name("password"));

            // fill and submit the form, etc. (you could also use JavaScript to do these tasks)
            emailField.sendKeys("your_email");
            passwordField.sendKeys("your_password" + Keys.ENTER);

            // Wait for Javascript operations
            Thread.sleep(10 * 1000);

            WebElement element = driver.findElement(By.id("elementId"));
        } finally {
            if (driver != null) driver.quit();
        }
    }
}