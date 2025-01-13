import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_76_76 {

  public static void main(String[] args) {
    ExampleTest_76 instance = new ExampleTest_76();
    try {
      instance.test();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.err.println("The thread was interrupted: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("An error occurred: " + e.getMessage());
    }
  }

  public void test() throws InterruptedException {
    // Ensure the ChromeDriver executable is in the PATH or specify its location here
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}