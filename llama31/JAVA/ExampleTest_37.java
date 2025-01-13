import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_37_37 {

  public static void main(String[] args) {
    try {
      new ExampleTest_37().test();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("The test was interrupted.");
    }
  }

  public void test() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Make sure to set the path to chromedriver
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}