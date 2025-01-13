import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_72_72 {

  @Test
  public void test() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) {
    org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> {
      ExampleTest_72 instance = new ExampleTest_72();
      instance.test();
    });
  }
}