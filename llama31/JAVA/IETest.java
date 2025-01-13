import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IETest {
    public static void main(String[] args) {
        System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer.exe");
        WebDriver driver1 = new InternetExplorerDriver();
        WebDriver driver2 = new InternetExplorerDriver();

        // Perform actions on each driver instance
        driver1.quit();
        driver2.quit();
    }
}