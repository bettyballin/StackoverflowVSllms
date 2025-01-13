import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_104_104 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Test login functionality
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("testuser");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("testpassword");
        driver.findElement(By.name("login")).click();

        // Verify login success
        WebElement loginSuccessMessage = driver.findElement(By.cssSelector(".login-success"));
        assert loginSuccessMessage.getText().equals("Login successful");

        driver.quit();
    }
}