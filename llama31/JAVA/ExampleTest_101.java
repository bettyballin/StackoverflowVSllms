import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_101_101 {

  public static void main(String[] args) throws InterruptedException {
    ExampleTest_101 test = new ExampleTest_101();
    test.test();
  }

  public void test() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}