import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browsermob.proxy.BrowserMobProxy;
import com.browsermob.proxy.har.Har;
import com.browsermob.proxy.har.HarCaptureTypes;
import com.browsermob.proxy.har.HarEntry;

import java.io.IOException;

public class Main_632 {
  public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();
    BrowserMobProxy proxy = new BrowserMobProxy();
    proxy.setHarCaptureTypes(HarCaptureTypes.REQUEST_CONTENT);
    proxy.setHarCaptureTypes(HarCaptureTypes.RESPONSE_CONTENT);

    // Set proxy to the driver
    System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
    System.setProperty("webdriver.firefox.bin", "path/to/firefox");
    proxy.newHar("example.com");
    WebDriver driver = new FirefoxDriver(capabilities(proxy));

    driver.get("https://example.com");

    // Capture HAR data
    Har har = proxy.getHar();

    // Iterate through the entries (requests/responses)
    for (HarEntry entry : har.getLog().getEntries()) {
      System.out.println("Request URL: " + entry.getRequest().getUrl());
      System.out.println("Response Status Code: " + entry.getResponse().getStatus());
      System.out.println("Response Time: " + entry.getTimings().getResponseTime() + " ms");
      if(entry.getResponse().getContent() != null) {
        System.out.println("Transfer Size: " + entry.getResponse().getContent().getSize() + " bytes");
      }
    }

    driver.quit();
    proxy.stop();
  }

  private static DesiredCapabilities capabilities(BrowserMobProxy proxy) {
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability(CapabilityType.PROXY, proxy.seleniumProxy());
    return capabilities;
  }
}