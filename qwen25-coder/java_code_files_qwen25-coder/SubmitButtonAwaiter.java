import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SubmitButtonAwaiter {
    // Example of using WebDriverWait in Java
    WebDriver driver = null;
    WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-button")));

    public static void main(String[] args) {
    }
}