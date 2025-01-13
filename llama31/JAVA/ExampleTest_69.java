import java.util.concurrent.TimeUnit;

// Assuming you have the necessary Selenium WebDriver JARs in your classpath
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_69_69 {

  public static void main(String[] args) throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    TimeUnit.SECONDS.sleep(3);
    driver.quit();
  }
}