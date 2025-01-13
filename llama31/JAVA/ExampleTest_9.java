import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_9_9 {

  public static void main(String[] args) throws InterruptedException {
    ExampleTest_9 instance = new ExampleTest_9();
    instance.test();
  }

  public void test() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}