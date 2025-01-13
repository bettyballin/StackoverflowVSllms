// Example Appium test in Java
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IPhoneTest {
    public static void main(String[] args) throws MalformedURLException {
        // Set up the Appium server URL
        URL url = new URL("http://localhost:4723/wd/hub");

        // Set up the device capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
        capabilities.setCapability(MobileCapabilityType.APP, "/path/to/your/app.ipa");

        // Create the IOSDriver instance
        IOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(url, capabilities);

        // Perform the test
        driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();

        // Close the driver
        driver.quit();
    }
}