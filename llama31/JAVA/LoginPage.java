import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

// LoginPage.java
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }
}

// LoginTest.java
public class LoginTest {
    @Test
    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("username", "password");
        Assert.assertTrue(driver.getTitle().contains("Login Success"));
        driver.quit();
    }

    public static void main(String[] args) {
        org.testng.TestNG.main(new String[] {"LoginTest"});
    }
}