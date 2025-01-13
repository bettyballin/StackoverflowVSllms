import java.net.URL;
import org.openqa.selenium.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;

public class OperaMobileEmulatorDriver {
    public static void main(String[] args) throws Exception {
        // Create a new instance of the Opera Mobile Emulator
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "opera");
        capabilities.setCapability("version", "11");
        capabilities.setCapability("platform", "Windows");
        capabilities.setCapability("device", "Opera Mobile Emulator");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), capabilities);

        // Navigate to your website and test the handheld CSS
        driver.get("https://example.com");
    }
}