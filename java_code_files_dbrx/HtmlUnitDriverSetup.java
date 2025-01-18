import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HtmlUnitDriverSetup {
    WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME); // Use any other browser version as needed
    // Proceed with your tests using the driver object
    {
        driver.close();
    }
    public static void main(String[] args) {
    }
}