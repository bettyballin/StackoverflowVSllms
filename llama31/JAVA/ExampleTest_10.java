import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_10_10 {

  public void test() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) throws InterruptedException {
    ExampleTest_10 test = new ExampleTest_10();
    test.test();
  }
}