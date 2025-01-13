import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class VBScriptTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://your-legacy-app.com");
        driver.findElement(By.id("someElement")).click(); // VBScript will be executed
        driver.quit();
    }
}