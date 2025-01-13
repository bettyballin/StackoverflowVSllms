import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_2_2 {

  @Test
  public void test() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) {
    org.junit.platform.launcher.core.LauncherDiscoveryRequest request = org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request()
      .selectors(org.junit.platform.engine.discovery.ClassSelector.of(ExampleTest_2.class))
      .build();
    org.junit.platform.launcher.core.LauncherFactory.create().execute(request);
  }
}