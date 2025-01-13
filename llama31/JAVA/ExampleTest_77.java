import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExampleTest_77_77 {

  @Test
  public void test() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    ChromeOptions options = new ChromeOptions();
    ChromeDriver driver = new ChromeDriver(options);
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) {
    org.junit.platform.launcher.core.LauncherFactory.create().execute(
      org.junit.platform.launcher.LauncherDiscoveryRequestBuilder.request()
        .selectors(org.junit.platform.engine.discovery.DiscoverySelectors.selectClass(ExampleTest_77.class))
        .build()
    );
  }
}