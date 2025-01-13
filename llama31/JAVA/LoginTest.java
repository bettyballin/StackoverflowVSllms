import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    @Test
    public void testLogin() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://example.com/login");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("username");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");
        driver.findElement(By.name("login")).click();
        // Verify login success
        driver.quit();
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("LoginTest");
    }
}