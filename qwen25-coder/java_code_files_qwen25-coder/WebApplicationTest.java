import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert; // Added missing import
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WebApplicationTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://example.com/login");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin() throws InterruptedException {
        LoginSteps.login(driver, "user@example.com", "password");
        Thread.sleep(2000); // Waiting for page to load
        Assert.assertTrue(UserPage.isOnUserPage(driver), "Expected User Page does not appear");
    }

    public static void main(String[] args) {
    }
}