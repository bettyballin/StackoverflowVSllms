import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ExampleTest_66_66 {

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Set path to chromedriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }

    // This main method is not necessary for running JUnit tests but can be useful for other purposes
    public static void main(String[] args) {
        // For running as a standard Java application, consider using a test runner
        // org.junit.platform.console.ConsoleLauncher.main(args);
    }
}