import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_94_94 {

  public void test() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }

  public static void main(String[] args) {
    ExampleTest_94 instance = new ExampleTest_94();
    try {
      instance.test();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt(); // Restore interrupted status
      System.err.println("Test was interrupted.");
    }
  }
}