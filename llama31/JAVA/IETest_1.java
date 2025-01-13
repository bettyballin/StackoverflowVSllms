import java.net.URL;
import java.lang.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IETest_1_1 {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setVersion("8");
        WebDriver driver = new RemoteWebDriver(
                new URL("http://username:password@hub.browserstack.com/wd/hub"),
                capabilities);
        driver.get("http://www.example.com");
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
        driver.quit();
    }
}