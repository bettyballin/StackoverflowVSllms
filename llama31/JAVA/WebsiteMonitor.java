import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteMonitor {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("http://example.com");
    WebElement element = driver.findElement(By.tagName("title"));
    if (element != null) {
      System.out.println("Website is available");
    } else {
      System.out.println("Website is not available");
    }
    driver.quit();
  }
}