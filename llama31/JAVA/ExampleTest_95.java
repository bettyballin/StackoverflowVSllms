import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_95_95 {

  public static void main(String[] args) throws InterruptedException {
    ExampleTest_95 test = new ExampleTest_95();
    test.test();
  }

  public void test() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // set the path to chromedriver
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}