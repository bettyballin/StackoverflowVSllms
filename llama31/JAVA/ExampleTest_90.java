import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

public class ExampleTest_90_90 {

  @Test
  public void test() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) {
    org.junit.platform.launcher.core.LauncherDiscoveryRequest request = org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request()
      .selectors(org.junit.platform.engine.discovery.DiscoverySelectors.selectClass(ExampleTest_90.class))
      .build();

    org.junit.platform.launcher.core.Launcher launcher = org.junit.platform.launcher.core.LauncherFactory.create();
    launcher.execute(request);
  }
}