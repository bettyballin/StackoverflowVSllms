import java.lang.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTest {

    public static void main(String[] args) {
        SmokeTest smokeTest = new SmokeTest();
        smokeTest.testLogin();
    }

    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Ensure to set the path to your chromedriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("username");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("password");
        driver.findElement(By.name("login")).click();
        // Verify login was successful
        driver.quit(); // Close the browser after the test
    }
}