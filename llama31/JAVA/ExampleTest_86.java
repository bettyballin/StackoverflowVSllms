import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_86_86 {

  @Test
  public void test() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) {
    ExampleTest_86 instance = new ExampleTest_86();
    try {
      instance.test();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}