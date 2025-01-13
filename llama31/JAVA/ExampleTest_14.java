import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ExampleTest_14_14 {

  @Test
  public void test() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) {
    org.junit.platform.launcher.LauncherFactory.create().execute(org.junit.platform.launcher.LauncherDiscoveryRequestBuilder.request()
      .selectors(org.junit.platform.engine.discovery.DiscoverySelectors.selectClass(ExampleTest_14.class))
      .build());
  }
}