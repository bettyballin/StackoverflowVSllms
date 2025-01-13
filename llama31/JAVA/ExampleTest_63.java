import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_63_63 {

  public static void main(String[] args) throws InterruptedException {
    ExampleTest_63 test = new ExampleTest_63();
    test.test();
  }

  public void test() throws InterruptedException {
    // Specify the path to chromedriver
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}