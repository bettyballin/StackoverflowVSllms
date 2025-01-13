import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_53_53 {

  @Test
  public void test() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    Thread.sleep(3000);
    driver.quit();
  }

  public static void main(String[] args) {
    org.junit.platform.launcher.core.LauncherFactory.create().execute(
      org.junit.platform.launcher.LauncherDiscoveryRequestBuilder.request()
        .selectors(org.junit.platform.engine.discovery.ClassSelector.of(ExampleTest_53.class))
        .build());
  }
}