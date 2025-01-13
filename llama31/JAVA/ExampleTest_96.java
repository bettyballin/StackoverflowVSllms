import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_96_96 {

  public static void main(String[] args) throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  // Commented out the test method as it requires JUnit to run
  // @Test
  // public void test() throws InterruptedException {
  //   ChromeDriver driver = new ChromeDriver();
  //   driver.get("https://www.google.com");
  //   TimeUnit.SECONDS.sleep(3);
  //   driver.quit();
  // }
}