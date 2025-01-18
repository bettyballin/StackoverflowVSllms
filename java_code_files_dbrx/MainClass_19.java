import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MainClass {
    public static void main(String[] args) throws Exception {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(8081); // start the proxy at port 8081

        // Configure the proxy as a Selenium proxy
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // Set up Firefox options to use the proxy
        FirefoxOptions options = new FirefoxOptions();
        options.setProxy(seleniumProxy);

        // Initialize the Firefox driver with the proxy settings
        WebDriver driver = new FirefoxDriver(options);

        // Use the WebDriver to navigate to the URL
        driver.get("http://example.com"); // execute your test as you would normally do

        Har har = proxy.getHar(); // capture network traffic
        for (HarEntry entry : har.getLog().getEntries()) {
            System.out.println(entry.getResponse().getStatus() + " " + entry.getRequest().getUrl());
        }

        driver.quit(); // Close the browser
        proxy.stop(); // stop the proxy in the end and gather more metrics, such as time to load page, total request count etc.
    }
}