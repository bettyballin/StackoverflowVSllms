import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_36_36 {

  public static void main(String[] args) throws InterruptedException {
    ExampleTest_36 test = new ExampleTest_36();
    test.test();
  }

  public void test() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}