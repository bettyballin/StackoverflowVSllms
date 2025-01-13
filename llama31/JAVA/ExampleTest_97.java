import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExampleTest_97_97 {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    ChromeOptions options = new ChromeOptions();
    ChromeDriver driver = new ChromeDriver(options);
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}