import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_74_74 {

  public static void main(String[] args) throws InterruptedException {
    ExampleTest_74 test = new ExampleTest_74();
    test.test();
  }

  public void test() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Set the path to chromedriver
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}