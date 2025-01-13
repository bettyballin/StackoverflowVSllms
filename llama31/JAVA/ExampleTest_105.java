import java.lang.String;
import java.lang.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExampleTest_105_105 {
    @Test
    public void testLogin() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://example.com/login");

        // Enter valid credentials
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("validusername");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("validpassword");

        // Submit the form
        driver.findElement(By.name("login")).click();

        // Verify the login was successful
        WebElement loggedInMessage = driver.findElement(By.cssSelector(".logged-in-message"));
        assert loggedInMessage.getText().equals("Welcome, validusername!");

        // Clean up
        driver.quit();
    }

    public static void main(String[] args) {
        org.testng.TestNG testng = new org.testng.TestNG();
        testng.setTestClasses(new Class[] { ExampleTest_105.class });
        testng.run();
    }
}