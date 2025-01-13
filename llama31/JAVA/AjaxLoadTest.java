import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.samplers.HTTPSamplerProxy;

public class AjaxLoadTest {
    public static void main(String[] args) {
        // Set up Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/ajax-app");

        // Set up JMeter
        StandardJMeterEngine jMeter = new StandardJMeterEngine();
        LoopController loopController = new LoopController();
        loopController.setLoops(10);

        // Create an HTTP sampler
        HTTPSamplerProxy sampler = new HTTPSamplerProxy();
        sampler.setMethod("GET");
        sampler.setPath("/ajax-request");

        // Add headers to the sampler
        HeaderManager headerManager = new HeaderManager();
        headerManager.addHeader(new Header("Accept", "application/json"));
        sampler.setHeaderManager(headerManager);

        // Add the sampler to the loop controller
        loopController.addTestElement(sampler);

        // Run the test
        jMeter.configure(loopController);
        jMeter.run();

        // Clean up
        driver.quit();
    }
}