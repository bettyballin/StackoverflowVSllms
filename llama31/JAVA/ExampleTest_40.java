import java.lang.String;
import java.util.concurrent.TimeUnit;

public class ExampleTest_40_40 {

  public void test() throws InterruptedException {
    // Assuming you have the Selenium WebDriver properly set up in your project
    // You will need to download the chromedriver and have it in your PATH or specify its location
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    org.openqa.selenium.chrome.ChromeDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) throws InterruptedException {
    ExampleTest_40 test = new ExampleTest_40();
    test.test();
  }
}