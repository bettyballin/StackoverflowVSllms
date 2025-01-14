import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPageTest(WebDriver driver) {
        this.driver = driver;
        // Setting a timeout of 10 seconds for the waits
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void testLogin() {
        driver.get("https://example.com/login");
        
        // Example: wait until the element is present and visible, then send text to it
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys("user@example.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys("securepassword123");
        
        // Example: perform a click action after the element is enabled
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginButton.click();
    }

    public static void main(String[] args) {
    }
}